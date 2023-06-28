package inc.flide.vim8.arbitaries;

import inc.flide.vim8.structures.FingerPosition;
import inc.flide.vim8.structures.KeyboardAction;
import java.util.List;
import java.util.Map;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ArbitrarySupplier;

public class KeyboardActionsEntryArbitrary
        implements ArbitrarySupplier<Map.Entry<List<FingerPosition>, KeyboardAction>> {
    @Override
    public Arbitrary<Map.Entry<List<FingerPosition>, KeyboardAction>> get() {
        Arbitrary<List<FingerPosition>> movementSequenceArbitrary = new MovementSequenceArbitrary().get();
        Arbitrary<KeyboardAction> keyboardActionArbitrary = new KeyboardActionArbitrary().get();
        return Arbitraries.entries(movementSequenceArbitrary, keyboardActionArbitrary);
    }
}