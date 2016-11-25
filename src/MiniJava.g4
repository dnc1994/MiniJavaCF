grammar MiniJava;

goal
    : mainClass (classDeclaration)* EOF
    ;

mainClass
    : 'class' name=Identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' Identifier ')' '{' statement '}' '}'
    ;

classDeclaration
    : 'class' name=Identifier ('extends' parent=Identifier)? '{' (varDeclaration)* (methodDeclaration)* '}'
    ;

varDeclaration
    : vtype=type name=Identifier ';'
    ;

methodDeclaration
    : 'public' rtype=type name=Identifier '(' paramList? ')' '{' (varDeclaration)* (statement)* 'return' expression ';' '}'
    ;

paramList
    : ptype=type name=Identifier
    | ptype=type name=Identifier ',' paramList
    ;

type
    : 'int' '[' ']'
    | 'boolean'
    | 'int'
    | Identifier
    ;

statement
    : '{' (statement)* '}'
    | ifStatement
    | whileStatement
    | printStatement
    | assignment
    | arrayAssignment
    ;

ifStatement
    : 'if' '(' expression ')' statement 'else' statement;

whileStatement
    : 'while' '(' expression ')' statement;

printStatement
    : 'System.out.println' '(' expression ')' ';';

assignment
    : Identifier '=' expression ';';

arrayAssignment
    : Identifier '[' expression ']' '=' expression ';';

expression
    : orExpr
    | andExpr
    | compareExpr
    | sumExpr
    | productExpr
    | atom
    ;

orExpr
    : (atom | productExpr | sumExpr | compareExpr | andExpr) '||' (atom | productExpr | sumExpr | compareExpr | andExpr)
    | orExpr '||' (atom | productExpr | sumExpr | compareExpr | andExpr)
    ; 

andExpr
    : (atom | productExpr | sumExpr | compareExpr) '&&' (atom | productExpr | sumExpr | compareExpr)
    | andExpr '&&' (atom | productExpr | sumExpr | compareExpr)
    ;

compareExpr
    : (atom | productExpr | sumExpr) ('==' | '<' | '>') (atom | productExpr | sumExpr)
    | compareExpr ('==' | '<' | '>') (atom | productExpr | sumExpr)
    ;

sumExpr
    : (atom | productExpr) ('+' | '-') (atom | productExpr)
    | sumExpr ('+' | '-') atom
    ;

productExpr
    : atom ('*' | '/') atom
    | productExpr ('*' | '/') atom
    ;

expression : expression ('&&' | '<' | '+' | '-' | '*') expression
           | expression '[' expression ']'
           | expression '.' 'length'
           | expression '.' Identifier '(' (expression (',' expression)* )? ')'
           | INT
           | 'true'
           | 'false'
           | Identifier
           | 'this'
           | 'new' 'int' '[' expression ']'
           | 'new' Identifier '(' ')'
           | '!' expression
           | '(' expression ')'
           ;

Identifier : [a-zA-Z_][a-zA-Z0-9_]*;

INT : [0-9]+;

WS : [ \t\r\n]+ -> skip;
