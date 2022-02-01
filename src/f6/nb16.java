package f6;

import java.util.LinkedList;
import java.util.Queue;

public class nb16 {

    public static void main(String[] args) {
        System.out.println(marbleSwitcher(2, 5, 0));
        System.out.println(marbleSwitcher(2, 1, 0));
        System.out.println(marbleSwitcher(2, 2, 3));
        System.out.println(marbleSwitcher(5, 2, 1));
    }

    private static int marbleSwitcher(int blue, int white, int red) {
        Queue<State> q = new LinkedList<>();
        State state = new State(blue, white, red, 0);

        while (!state.solved()) {
            if (state.switches > 15) {
                return Integer.MAX_VALUE;
            } else {
                if (state.blue > state.white || state.blue > state.red)
                    q.offer(new State(state.blue - 1, state.white + 1, state.red + 3, state.switches + 1));
                if (state.white > state.red || state.white > state.blue)
                    q.offer(new State(state.blue + 2, state.white - 1, state.red + 4, state.switches + 1));
                if (state.red > state.white || state.red > state.blue)
                    q.offer(new State(state.blue + 1, state.white + 5, state.red - 1, state.switches + 1));
                state = q.poll();
            }
        }
        return state.switches;
    }

    private static class State {
        public int blue;
        public int white;
        public int red;
        public int switches;

        public State(int blue, int white, int red, int switches) {
            this.blue = blue;
            this.white = white;
            this.red = red;
            this.switches = switches;
        }

        public boolean solved() {
            return blue == white && white == red;
        }
    }
}
