package bayesiannetwork;

// Generated from bayesian.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Pars}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface bayesianVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Pars#evidenceVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvidenceVariable(@NotNull Pars.EvidenceVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link Pars#queryVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryVariable(@NotNull Pars.QueryVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link Pars#bayes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBayes(@NotNull Pars.BayesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Pars#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(@NotNull Pars.FactorContext ctx);
}