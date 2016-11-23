grammar MiniJava;

goal : mainClass (classDeclaration)* EOF;

mainClass : 'class' identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' identifier ')' '{' statement '}' '}';

classDeclaration : 'class' name=identifier ('extends' parent=identifier)? '{' (varDeclaration)* (methodDeclaration)* '}';

varDeclaration : vtype=type name=identifier ';';

methodDeclaration : 'public' rtype=type name=identifier '(' (type identifier (',' type identifier)* )? ')' '{' (varDeclaration)* (statement)* 'return' expression ';' '}';

type : 'int' '[' ']'
     | 'boolean'
     | 'int'
     | identifier
     ;

statement : '{' (statement)* '}'
          | 'if' '(' expression ')' statement 'else' statement
          | 'while' '(' expression ')' statement
          | 'System.out.println' '(' expression ')' ';'
          | identifier '=' expression ';'
          | identifier '[' expression ']' '=' expression ';'
          ;

expression : expression ('&&' | '<' | '+' | '-' | '*') expression
           | expression '[' expression ']'
           | expression '.' 'length'
           | expression '.' identifier '(' (expression (',' expression)* )? ')'
           | INT
           | 'true'
           | 'false'
           | identifier
           | 'this'
           | 'new' 'int' '[' expression ']'
           | 'new' identifier '(' ')'
           | '!' expression
           | '(' expression ')'
           ;

identifier : ID;

INT : [0-9]+;
ID : [a-zA-Z_][a-zA-Z0-9_]*;
WS : [ \t\r\n]+ -> skip;
