# Architecture

## Package `net.genevaub`

Package principal
- `net.genevaub.Main` classe d'entrée
- `net.genevaub.Orchestrator` orchestrateur entre les différents éléments du projet

## Package `net.genevaub.lawnmower`

Package gérant la tonte de pelouse
- `net.genevaub.lawnmower.Lawn` description de la pelouse
- `net.genevaub.lawnmower.Mower` description d'une tondeuse
- `net.genevaub.lawnmower.Position` description d'une position

## Package `net.genevaub.file`

Package gérant le fichier d'entrée
- `net.genevaub.file.Parser` parseur de fichier
- `net.genevaub.file.Token` description d'un token