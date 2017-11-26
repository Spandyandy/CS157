(* Mathematica package *)

Begin["EntityFramework`Dialog`"];

$tag = "EntityFrameworkCatchThrowTag"; (*same as general EF $tag*)

FrontEndAvailableQ[] := SameQ[Head[$FrontEnd],FrontEndObject]

GenericProgressIndicator[val_?NumericQ, width_: 200, height_: 20] := Overlay[{
   Panel[Spacer[.0001], Appearance -> $GPIBackground, 
    FrameMargins -> 0, ImageSize -> {width, height}],
   Panel[Spacer[.0001], Appearance -> $GPIForeground, 
    FrameMargins -> 0, ImageSize -> {val width, height}]
   }]
  
GenericProgressIndicator[Except[_?NumericQ], width_, height_] := GenericProgressIndicator[0, width, height]

getProgress[batches_,progress_] := If[progress<=Length[batches],batches[[progress]],Last[batches]]

loadingPanel[text_] := Panel[Style[text, "Button", GrayLevel[.5]], 
 Appearance -> $PaneBackground,
 Alignment -> {Center, Center},
 FrameMargins -> {{12, 12}, {8, 12}}
]

(*for EntityValue[type,"Entities"]*)
interruptableEntityDownloadManager[class:(_String|_Entity|_EntityClass), batches_List, type_:"Entities"] := 
 Block[{elements = Length[batches], list = {{{}}}}, 
  DynamicModule[{
  	stopQ = False, progress = 1, display = Row[{"  ", Tooltip[$StopButton, "Stop and use results so far"]
  		}]},
  	If[FrontEndAvailableQ[],
  		Monitor[
  			list = Reap[Catch[
  				Do[
  					If[TrueQ[stopQ],Throw["Stopped", $tag],
  					Sow[EntityFramework`Private`downloadEntityBatch[class, batches[[progress]], type]];progress++], 
  					{elements}];
  				list,
  			$tag]],
  			Panel[Column[{
  				Style[Row[{Switch[type,
  					"EntityClasses"|"EntityClassCanonicalNames", "Downloading entity classes ",
  					_,"Downloading entities "], 
  				Dynamic[Row[Insert[getProgress[batches,progress]," through ",2]]],
  				" of ",
  				Last[Last[batches]], 
  				" ...."}], "Button", GrayLevel[.5]],
  				Grid[{
  					{Dynamic[GenericProgressIndicator[progress/elements, 200, 12]], Spacer[8], 
  						Button[Dynamic[display], 
  							Set[display, Style["Stopping ....","Button",GrayLevel[.5]]]; Set[stopQ, True],
  							 Appearance -> None]}}, Spacings -> 0, Alignment -> {Center, Top}]
  				}], 
  				Appearance->$PaneBackground, 
  				Alignment -> {Center, Center}, 
  				FrameMargins -> {{12, 12}, {8, 12}}],
  			.1],
  			Print["Downloading ",Last[Last[batches]],Switch[type,
      		"EntityClasses"|"EntityClassCanonicalNames", " entity classes ....",
      		_," entities ...."]];
  			list = Reap[Catch[
  				Do[
  					If[TrueQ[stopQ],Throw["Stopped", $tag],
  					Sow[EntityFramework`Private`downloadEntityBatch[class, batches[[progress]], type]];progress++], 
  					{elements}];
  				list,
  			$tag]]
  ]];
  		Join@@DeleteCases[First[Last[list]],Except[_List]]
  ]
  
(*for EntityValue[<list of entities>, "prop"]*)  
interruptableDataDownloadManager[batches_List, entities_List, args___] := 
 Block[{elements = Length[batches], list = {{{}}}}, 
  DynamicModule[{stopQ = False, progress = 1, display = Tooltip[$StopButton, "Stop and use results so far"]}, 
   If[FrontEndAvailableQ[], 
     Monitor[
     	list = Reap[Catch[Do[
     		If[TrueQ[stopQ],Throw["Stopped", $tag], 
     		Sow[EntityValueOrError[Take[entities, batches[[progress]]], args]];progress++],
    		{elements}];
    	list, $tag]],
    	Panel[Column[{
      		Style[Row[{"Downloading ", Length[entities], " values ...."}], "Button",GrayLevel[.5]], 
       		Grid[{{
        		Dynamic[GenericProgressIndicator[progress/elements, 200, 12]], 
        		Spacer[8], 
        		Button[Dynamic[display], 
        			Set[display, Style["Stopping ....","Button",GrayLevel[.5]]]; 
        			Set[stopQ, True], 
        			Appearance -> None]}},
        		Spacings -> 0, 
        		Alignment -> {Center, Top}]
        	}],
        Appearance->$PaneBackground, 
        Alignment -> {Center, Center}, 
        FrameMargins -> {{12, 12}, {8, 12}}],
      .1],
     Print["Downloading ", Length[entities], " values ...."];
     list = Reap[Catch[
    	Do[
    		If[TrueQ[stopQ], 
    			Throw["Stopped", $tag], 
    			Sow[EntityValueOrError[Take[entities, batches[[progress]]], args]];progress++
    		],
    		{elements}];
    	list, $tag]]
      ]];
   Join@@DeleteCases[First[Last[list]],Except[_List|_Association]]
  ]  
  
interruptableDataDownloadManager[group_, batches_List, {args___}] := 
 Block[{elements = Length[batches], list = {{{}}}, count = Last[Last[batches]]}, 
  DynamicModule[{stopQ = False, progress = 1, display = Tooltip[$StopButton, "Stop and use results so far"]}, 
   If[FrontEndAvailableQ[], 
     Monitor[
     	list = 
    Reap[Catch[
    	Do[
    		If[TrueQ[stopQ], 
    			Throw["Stopped", $tag], 
    			Sow[EntityValueSpanOrError[batches[[progress]],Switch[group,
    				_String,Entity[group, _, Span@@batches[[progress]]],
    				Entity[_String],Fold[Append,group,{_, Span@@batches[[progress]]}],
    				_EntityClass,Entity[group, _, Span@@batches[[progress]]],
    				_,Throw[$Failed,$tag]
    				], args]];progress++
    		],
    		{elements}];
      list, $tag]],
      Panel[Column[{
      	Style[Row[{"Downloading ", count, " values ...."}], "Button",GrayLevel[.5]], 
        Grid[{{Dynamic[GenericProgressIndicator[progress/elements, 200, 12]], Spacer[8], 
   Button[Dynamic[display], Set[display, Style["Stopping ....","Button",GrayLevel[.5]]]; 
    Set[stopQ, True], Appearance -> None]}}, Spacings -> 0, Alignment -> {Center, Top}]
      }],Appearance->$PaneBackground, Alignment -> {Center, Center}, FrameMargins -> {{12, 12}, {8, 12}}],
      .1], 
     Print["Downloading ", Last[Last[batches]], " values ...."];
     list = 
    Reap[Catch[
    	Do[
    		If[TrueQ[stopQ], 
    			Throw["Stopped", $tag], 
    			Sow[EntityValueSpanOrError[batches[[progress]],Switch[group,
    				_String,Entity[group, _, Span@@batches[[progress]]],
    				Entity[_String],Fold[Append,group,{_, Span@@batches[[progress]]}],
    				_EntityClass,Entity[group, _, Span@@batches[[progress]]],
    				_,Throw[$Failed,$tag]
    				], args]];progress++
    		],
    		{elements}];
      list, $tag]]
     ]];
   Join@@DeleteCases[First[Last[list]],Except[_List|_Association]]
  ]

EntityValueOrError[args___] := With[{res = EntityValue[args]},
	If[Or[SameQ[res, $Failed],Head[res] === EntityValue], 
		With[{l=If[Length[{args}]>=1,Length[First[{args}]],0]},
			Message[EntityValue::nodat];
			If[UnsameQ[l,0] && SameQ[Last[{args}], "EntityAssociation"],
				Association[Thread[Rule[First[{args}],#]]], #]&[Table[Missing["RetrievalFailure"],{i,l}]]],
			 res]
]

EntityValueSpanOrError[{start_Integer,end_Integer},args___] := With[{res = EntityValue[args]},
	If[Or[SameQ[res,$Failed],Head[res] === EntityValue], 
		With[{l=If[Length[{args}]>=1,Length[First[{args}]],0]},
			Message[EntityValue::nodat];
			If[UnsameQ[l,0] && SameQ[Last[{args}], "EntityAssociation"],
				Association[Thread[Rule[First[{args}],#]]], #]&[Table[Missing["RetrievalFailure"],{i,start,end}]]],
			 res]
]


(************************************IMAGES***************************************)
$GPIBackground = \!\(\*
GraphicsBox[
TagBox[RasterBox[CompressedData["
1:eJxTTMoPSmNiYGAo5gASQYnljkVFiZXBLECOU2VJahIzkCECxLxADBL8jwZA
QugYG5g3b14UEB8G4v94MEg+CknP4T17D/w/c/7i/wuXr2FgkDhIHqQOSQ9Y
/OqN2/9v33uIgUHiIHmQOph7QWyQeSD5B4+fYWCQOEh+VM+oHkr1kJpGScoL
+8B54QiJee4IEEdjy7PE5G0AAMgtsA==
"], {{0, 20}, {13, 0}}, {0, 255},
ColorFunction->RGBColor],
BoxForm`ImageTag["Byte", ColorSpace -> "RGB", Interleaving -> True],
Selectable->False],
BaseStyle->"ImageGraphics",
ImageSizeRaw->{13, 20},
PlotRange->{{0, 13}, {0, 20}}]\);

$GPIForeground = \!\(\*
GraphicsBox[
TagBox[RasterBox[CompressedData["
1:eJxTTMoPSmNiYGAo5gASQYnljkVFiZXBLECOU2VJahIzkCECxLxADBL8jwZA
QugYB2AgAcP1XHn+6TAQ/8eDD6PrOf/0439CGOJ0uHsZjj94958QRtez786b
/4Qwup6t117+J4TR9ay5+Pw/IYyuZ/GZJ/8JYXQ9c048+k8Io+tp3HXrPyE8
qgehB5ZGidWDnK6BYocJ6DmCroeMPIfQTETeBgDd8w75
"], {{0, 20}, {13, 0}}, {0, 255},
ColorFunction->RGBColor],
BoxForm`ImageTag["Byte", ColorSpace -> "RGB", Interleaving -> True],
Selectable->False],
BaseStyle->"ImageGraphics",
ImageSizeRaw->{13, 20},
PlotRange->{{0, 13}, {0, 20}}]\);

$StopButton = \!\(\*
GraphicsBox[
TagBox[RasterBox[CompressedData["
1:eJyNlMtPE1EUh0egRkyjJKCJruo/YdzquivUva3gysQETQxrFHxEExQUlq7w
LRXR+MCgQn2ALXUqIjVtJ0JjqZCWCu10Hj/PGaeTcWi1N/ma6dz5zjn33Duz
x3+i9VidIAgnt9BPq+/0/o4OX+fBBvpzoPNUu7+eLpqJJoJvAhDarz1ELfCz
leC5i09m/kk1n0etvlBllP0Lj8N/UbPfHzCdEAbHo0hkclgrKigqKsJSxpj7
vx/C+dGQ4U7El3EzvIgbU98hplahajo+xBaq+Zss/9FHXB+LIL6URbag4PZM
Cl3P5jEQTGIhW+D+RSv5beRz7nMj0+gJvEf38Du8/CwhX5AREH8YMZjlNRm6
rg9V96fQTf6Z+0F03ZvEyHQMmq6j50XM8AeDEtdQYMe5/ra+YRy9+gC+3rs4
cvkWfJeG4CdW8uu4Y66DSeeLKJVKhyjOVnsNBJ9aF9Ho8XiaOBGl5lF69e2n
5UdSOeOe9mdyn8PnI93o9XpbeHp0No3+iSSuvI5bfi9d971JYGw+w/5bRw3s
84uzLZFIHF/MFSzPSeaXDFVVvdV8Ygetc46fs3tnn8ewSmeL9iFq76P5LvAa
NhNuooXYLcvy1y/pvOUnV9ahadonmquv4Jf7wDVsJ3YSu7iOp3NLGKc+kjtr
5tjg22IYfTRjNIuieFhRlAgxKUnSXnOf6pznwBHDZdbhNvvhNmNuyG3voSNG
eU9dptdQzlv+dvwG45ZP0Q==
"], {{0, 19}, {16, 0}}, {0, 255},
ColorFunction->RGBColor],
BoxForm`ImageTag["Byte", ColorSpace -> "RGB", Interleaving -> True],
Selectable->False],
BaseStyle->"ImageGraphics",
ImageSizeRaw->{16, 19},
PlotRange->{{0, 16}, {0, 19}}]\);

$PaneBackground = \!\(\*
GraphicsBox[
TagBox[RasterBox[CompressedData["
1:eJxTTMoPSmNiYGAo5gASQYnljkVFiZXBLECOU2VJahIzkCEDxLxADGL/hwEG
bOA/Enjz6du1R69P3nyKiYDiQFmIMiD75aefn3/9x0RAcaAsxGSgLqxqIAgo
O6psVNmoMlKVEcyAV8EZEH92Bqp58/Eb/pIBuXwAAPU5YYU=
"], {{0, 28}, {13, 0}}, {0, 255},
ColorFunction->RGBColor],
BoxForm`ImageTag["Byte", ColorSpace -> "RGB", Interleaving -> True],
Selectable->False],
BaseStyle->"ImageGraphics",
ImageSizeRaw->{13, 28},
PlotRange->{{0, 13}, {0, 28}}]\);

End[];