# MiniJavaCF

Project for 2016 Fall's Compilers course @ Fudan University.

The task is to build a compiler frontend for [MiniJava](http://www.cambridge.org/us/features/052182060X/index.html).

Implemented with [ANTLR](http://www.antlr.org/) v4.5.3.

## Author

Linghao Zhang ([13307130225@fudan.edu.cn](13307130225@fudan.edu.cn))

## Usage

- `make grammar`: Generate ANTLR lexer & parser & visitor boilerplate codes from `MiniJava.g4`.
- `make build`: Compile all the Java codes.
- `make test`: Output the AST for `BinaryTree.java` in LISP-style string.
- `make rig`: Display the AST for `BinaryTree.java` in tree-style diagram.
- `make tests`: Test for syntax errors.
- `make test1`: Test for duplicated declaration.
- `make test2`: Test for type lookup.
- `make test3`: Test for symbol lookup and type compatibility.
- `make testc`: Test for cyclic inheritence.
