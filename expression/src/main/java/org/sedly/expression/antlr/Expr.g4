grammar Expr;

parse
    : atomExpr
    ;

logicExpr: condExpr ( (AND | OR) condExpr)*;

condExpr
    : arithmExpr (EQUALS | NOT_EQUALS | GREATER | LESS | GREATER_EQUALS | LESS_EQUALS) arithmExpr
    ;

arithmExpr
    : multExpr ( (PLUS | MINUS) multExpr)*
    ;

multExpr
    : atom ( (MULT | DIV) atom)*
    ;

atomExpr
    : logicExpr
    | condExpr
    | arithmExpr
    ;

valueExpr
    : DOUBLE 
    ;

atom 
    : valueExpr
    | (LB atomExpr RB)
    ;

DOUBLE 
    : INTEGER '.' INTEGER
    ;

INTEGER 
    : DIGIT+
    ;

DIGIT
    : '0'..'9'
    ;

PLUS        : '+' ;
MINUS       : '-' ;
MULT        : '*' ;
DIV         : '/' ;

NOT : '!';
AND: '&';
OR : '|';

EQUALS      : '=';
LESS        : '<';
GREATER        : '>';
GREATER_EQUALS : GREATER EQUALS;
LESS_EQUALS : LESS EQUALS;
NOT_EQUALS : NOT EQUALS;

LB : '(';
RB : ')';

SQ	:	'\'';
DQ 	:	'"';

WS : [ \t\r\n]+ -> skip ;