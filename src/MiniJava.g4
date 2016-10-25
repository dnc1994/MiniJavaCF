grammar MiniJava;

Goal : MainClass (ClassDeclaration)* EOF;

MainClass : 'class' Identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' Identifier ')' '}' Statement '}' '}';

ClassDeclaration : 'class' Identifier ('extends' Identifier)? '{' (VarDeclaration)* (MethodDeclaration)* '}';

VarDeclaration : Type Identifier ';';

MethodDeclaration : 'public' Type Identifier '(' (Type Identifier (',' Type Identifier)* )? ')' '{' (VarDeclaration)* (Statement)* 'return' Expression ';' '}';

Type : 'int' '[' ']'
     | 'boolean'
     | 'int'
     | Identifier
     ;

Statement : '{' (Statement)* '}'
          | 'if' '(' Expression ')' Statement 'else' Statement
          | 'while' '(' Expression ')' Statement
          | 'System.out.println' '(' Expression ')' ';'
          | Identifier '=' Expression ';'
          | Identifier '[' Expression ']' '=' Expression ';'
          ;

Expression : Expression ('&&' | '<' | '+' | '-' | '*') Expression
           | Expression '[' Expression ']'
           | Expression '.' 'length'
           | Expression '.' Identifier '(' (Expression (',' Expression)* )? ')'
           | INT
           | 'true'
           | 'false'
           | Identifier
           | 'this'
           | 'new' 'int' '[' Expression ']'
           | 'new' Identifier '(' ')'
           | '!' Expression
           | '(' Expression ')'
           ;

Identifier : ID;

INT : [0-9]+;
ID : [a-zA-Z_][a-zA-Z0-9_]*;
WS : [ \t\r\n]+ -> skip;
