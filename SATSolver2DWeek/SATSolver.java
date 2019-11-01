package sat;

import immutable.ImList;
import sat.env.*;
import immutable.EmptyImList;
import sat.formula.*;


/**
 * A simple DPLL SAT solver. See http://en.wikipedia.org/wiki/DPLL_algorithm
 */
public class SATSolver {
    /**
     * Solve the problem using a simple version of DPLL with backtracking and
     * unit propagation. The returned environment binds literals of class
     * bool.Variable rather than the special literals used in classification of
     * class clausal.Literal, so that clients can more readily use it.
     *
     * @return an environment for which the problem evaluates to Bool.TRUE, or
     * null if no such environment exists.
     */
    public static Environment solve(Formula formula) {
        Environment e = new Environment();

        ImList<Clause> clauses = formula.getClauses();

        Environment result = solve(clauses, e);
        return result;
    }


    /**
     * Takes a partial assignment of variables to values, and recursively
     * searches for a complete satisfying assignment.
     *
     * @param clauses formula in conjunctive normal form
     * @param env     assignment of some or all variables in clauses to true or
     *                false values.
     * @return an environment for which all the clauses evaluate to Bool.TRUE,
     * or null if no such environment exists.
     */
    private static Environment solve(ImList<Clause> clauses, Environment env) {
        if (clauses.isEmpty())
            return env;
        Clause smallest;
        smallest = getSmallest(clauses);

        if (smallest == null)
            return null;

        Literal l = smallest.chooseLiteral(); // choose the single literal
        Variable v = l.getVariable();

        if (smallest.isUnit()) { //one literal
            if (l instanceof PosLiteral) { // if literal is +ve
                return solveP(env, clauses, v, l);
            } else {
                return solveN(env, clauses, v, l);
            }
        } else { // for clauses that have more than 1 literal
            Environment f1 = posL(v, clauses, env);
            if (f1 == null) { // move to next branch
                Environment f2 = negL(v, clauses, env);
                return f2;
            }
            return f1; // return env not null
        }
    }

    private static Environment solveP(Environment env, ImList cl, Variable v, Literal l) {
        Environment envT = env.putTrue(v); // set env to be true
        ImList clT = substitute(cl, l); // replace all literals in clauses with true
        return solve(clT, envT); // solve recursively
    }

    private static Environment solveN(Environment env, ImList cl, Variable v, Literal l) {
        Environment envT = env.putFalse(v); // set env to be true
        ImList clT = substitute(cl, l); // replace all literals in clauses with true
        return solve(clT, envT); // solve recursively
    }

    private static Clause getSmallest(ImList<Clause> clauses) {
        Clause smallest = clauses.first();
        for (Clause each_clause : clauses) {
            if (each_clause.size() < smallest.size())
                smallest = each_clause;
            if (each_clause.isEmpty())
                return null;
        }
        return smallest;
    }

    private static Environment posL(Variable v, ImList cl, Environment env) {
        Environment envP = env.putTrue(v);
        Literal lP = PosLiteral.make(v);
        ImList clP = substitute(cl, lP);
        Environment ef1 = solve(clP, envP);
        return ef1;
    }

    private static Environment negL(Variable v, ImList cl, Environment env) {
        Environment envN = env.putFalse(v);
        Literal lN = NegLiteral.make(v);
        ImList clN = substitute(cl, lN);
        Environment ef2 = solve(clN, envN);
        return ef2;
    }


    /**
     * given a clause list and literal, produce a new list resulting from
     * setting that literal to true
     *
     * @param clauses , a list of clauses
     * @param l       , a literal to set to true
     * @return a new list of clauses resulting from setting l to true
     */
    private static ImList<Clause> substitute(ImList<Clause> clauses,
                                             Literal l) {
        ImList<Clause> new_clauses = new EmptyImList<>();

        for (Clause c : clauses) {
            if (l != null) {
                Clause new_c = c.reduce(l); // set literal to true or false
                if (new_c != null) {
                    new_clauses = new_clauses.add(new_c); // append to new clauses
                }
            }
        }
        return new_clauses;
    } //d10tf
}
