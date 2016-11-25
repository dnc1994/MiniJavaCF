// Generated from MiniJava.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaParser}.
 */
public interface MiniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(MiniJavaParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(MiniJavaParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(MiniJavaParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(MiniJavaParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(MiniJavaParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(MiniJavaParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(MiniJavaParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(MiniJavaParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniJavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MiniJavaParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MiniJavaParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MiniJavaParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MiniJavaParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(MiniJavaParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(MiniJavaParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MiniJavaParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MiniJavaParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#arrayAssignment}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#arrayAssignment}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(MiniJavaParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(MiniJavaParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(MiniJavaParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(MiniJavaParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#compareExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpr(MiniJavaParser.CompareExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#compareExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpr(MiniJavaParser.CompareExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#sumExpr}.
	 * @param ctx the parse tree
	 */
	void enterSumExpr(MiniJavaParser.SumExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#sumExpr}.
	 * @param ctx the parse tree
	 */
	void exitSumExpr(MiniJavaParser.SumExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#productExpr}.
	 * @param ctx the parse tree
	 */
	void enterProductExpr(MiniJavaParser.ProductExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#productExpr}.
	 * @param ctx the parse tree
	 */
	void exitProductExpr(MiniJavaParser.ProductExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#callList}.
	 * @param ctx the parse tree
	 */
	void enterCallList(MiniJavaParser.CallListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#callList}.
	 * @param ctx the parse tree
	 */
	void exitCallList(MiniJavaParser.CallListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#rightValue}.
	 * @param ctx the parse tree
	 */
	void enterRightValue(MiniJavaParser.RightValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#rightValue}.
	 * @param ctx the parse tree
	 */
	void exitRightValue(MiniJavaParser.RightValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(MiniJavaParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(MiniJavaParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#nonAtom}.
	 * @param ctx the parse tree
	 */
	void enterNonAtom(MiniJavaParser.NonAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#nonAtom}.
	 * @param ctx the parse tree
	 */
	void exitNonAtom(MiniJavaParser.NonAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(MiniJavaParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(MiniJavaParser.ArrayContext ctx);
}