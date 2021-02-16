package commands;

public interface Command <R,I>{
  R execute(I... input);
}
