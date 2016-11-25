// Generated from MiniJava.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(MiniJavaParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClass(MiniJavaParser.MainClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(MiniJavaParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(MiniJavaParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MiniJavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MiniJavaParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MiniJavaParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(MiniJavaParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MiniJavaParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#arrayAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(MiniJavaParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(MiniJavaParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#compareExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(MiniJavaParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#sumExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumExpr(MiniJavaParser.SumExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#productExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProductExpr(MiniJavaParser.ProductExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#callList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallList(MiniJavaParser.CallListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#rightValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightValue(MiniJavaParser.RightValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(MiniJavaParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#nonAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonAtom(MiniJavaParser.NonAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(MiniJavaParser.ArrayContext ctx);
}