package sat;


//import static org.junit.Assert.*;
//import org.junit.Test;


import sat.env.*;
import sat.formula.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SATSolverTest {
    Literal a = PosLiteral.make("a");
    Literal b = PosLiteral.make("b");
    Literal c = PosLiteral.make("c");
    Literal na = a.getNegation();
    Literal nb = b.getNegation();
    Literal nc = c.getNegation();

    public static void main(String[] args) throws IOException {
        Formula f = new Formula();

        // read file
        FileInputStream in = new FileInputStream("C:\\Users\\phang\\Desktop\\Project-2D\\Project-2D-starting\\sampleCNF\\beforedin.cnf");
        BufferedReader br = new BufferedReader((new InputStreamReader(in)));

        // initialize values
        String[] per_part;
        String per_line;
        int total_var = 0;

        // read line by line
        while ((per_line = br.readLine()) != null) {
            per_part = per_line.trim().split(" ");
            per_line.trim();
            // skips lines till reaches clauses and literals
            if(!per_line.isEmpty()) {
                if (!Character.isAlphabetic(per_line.charAt(0)) && !(per_line.isEmpty())) {
                    Clause temp_c = new Clause();

                    // iterate throughout each literal in each clause
                    for (String per_var : per_part) {
                        // 0 indicates each clause, set negative and positive literal
                        if (!per_var.equals("0")) {
                            if (per_var.matches("(-).*"))
                                temp_c = temp_c.add(NegLiteral.make(per_var.substring(1)));
                            else if (per_var.isEmpty()){
                                continue;
                            }
                            else
                                temp_c = temp_c.add(PosLiteral.make(per_var));
                        }
                    }
                    f = f.addClause(temp_c);
                } else if (per_line.matches("(p).*")) { // get total variables in the clauses
                    total_var = Integer.parseInt(per_part[2]);
                }
            }
        }
        in.close();
        System.out.println("SAT solver starts!!!");
        long started = System.nanoTime();
        Environment e = SATSolver.solve(f);
        long time = System.nanoTime();
        long timeTaken = time - started;
        System.out.println("Time:" + timeTaken / 1000000.0 + "ms");
        if (e != null) {
            System.out.println("Sat");
            Path path = Paths.get("C:\\Users\\phang\\Desktop\\Project-2D\\Project-2D-starting\\sampleCNF\\output.txt");
            try (
                    // write to file path in UTF-8 format
                    BufferedWriter w = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
                for (int i = 1; i <= total_var; i++) {
                    // iterate through all literals
                    Bool bool = e.get(new Variable(Integer.toString(i)));
                    if (bool == Bool.TRUE)
                        w.write(Integer.toString(i) + "-T\n");
                    else
                        w.write(Integer.toString(i) + "-F\n");
                }
            } catch (
                    IOException e1) {
                e1.printStackTrace();
            }
        } else {
            System.out.println("Unsat");
        }
    }

    public void testSATSolver1() {
        // (a v b)
        Environment e = SATSolver.solve(makeFm(makeCl(a, b)));

/*
    assertTrue( "one of the literals should be set to true",
            Bool.TRUE == e.get(a.getVariable())
            || Bool.TRUE == e.get(b.getVariable())  );

*/
    }


    public void testSATSolver2() {
        // (~a)
        Environment e = SATSolver.solve(makeFm(makeCl(na)));
/*
    assertEquals( Bool.FALSE, e.get(na.getVariable()));
*/
    }

    private static Formula makeFm(Clause... e) {
        Formula f = new Formula();
        for (Clause c : e) {
            f = f.addClause(c);
        }
        return f;
    }


    private static Clause makeCl(Literal... e) {
        Clause c = new Clause();
        for (Literal l : e) {
            c = c.add(l);
        }
        return c;
    }//d10tf
}
