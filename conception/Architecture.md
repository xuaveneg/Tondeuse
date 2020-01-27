# Architecture

## Package `net.genevaub`

Package principal
- `net.genevaub.Main` classe d'entrée

## Package `net.genevaub.lawnmower`

Package gérant la tonte de pelouse
- `net.genevaub.lawnmower.Direction` énumération d'une direction de tondeuse
- `net.genevaub.lawnmower.Lawn` description de la pelouse
- `net.genevaub.lawnmower.LawnBuilder` construction d'une pelouse
- `net.genevaub.lawnmower.LawnException` problème lié à la pelouse
- `net.genevaub.lawnmower.Move` énumération d'un mouvement de tondeuse
- `net.genevaub.lawnmower.Mower` description d'une tondeuse
- `net.genevaub.lawnmower.MowerList` liste de tondeuses
- `net.genevaub.lawnmower.Position` description d'une position

## Package `net.genevaub.file`

Package gérant le fichier d'entrée
- `net.genevaub.file.LineReader` lecteur d'une ligne
- `net.genevaub.file.LineType` énumération des types de ligne
- `net.genevaub.file.Parser` parseur de fichier
- `net.genevaub.file.ParserException` problème lié au parseur d'un fichier