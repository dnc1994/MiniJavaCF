import org.antlr.v4.runtime.*;
import java.util.*;

public class TypeEvaluator extends MiniJavaBaseVisitor<String> {
    private TypeChecker typeChecker;

    public TypeEvaluator(TypeChecker typeChecker) {
        this.typeChecker = typeChecker;
    }

    
}
