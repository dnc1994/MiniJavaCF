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
    : 'public' rtype=type name=Identifier '(' paramList? ')' '{' (varDeclaration)* (statement)* 'return' rightValue ';' '}'
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
    : name=Identifier '=' rightValue ';';

arrayAssignment
    : name=Identifier '[' expression ']' '=' expression ';';

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
    | sumExpr ('+' | '-') (atom | productExpr)
    ;

productExpr
    : atom ('*' | '/') atom
    | productExpr ('*' | '/') atom
    ;

callList
    : rightValue
    | rightValue ',' callList
    ;

rightValue
    : expression
    | nonAtom
    | array
    ;

atom
    : Int
    | bool='true'
    | bool='false'
    | array '[' atom ']'
    | array '.' 'length'
    | nonAtom '.' name=Identifier '(' callList? ')'
    | name=Identifier
    | '!' atom
    | '(' expression ')'
    ;

nonAtom
    : nonAtom '.' name=Identifier '(' callList? ')'
    | name=Identifier
    | self='this'
    | create='new' name=Identifier '(' ')'
    | '(' expression ')'
    ;

array
    : name=Identifier
    | create='new' 'int' '[' expression ']'
    | nonAtom '.' name=Identifier '(' callList? ')'
    ;

Identifier
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

Int
    : [0-9]+
    ;

WhiteSpace
    : [ \t\r\n]+ -> skip
    ;

LineComment
    : '//' ~[\r\n]* -> skip
    ;
