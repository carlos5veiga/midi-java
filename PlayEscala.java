import javax.sound.midi.*;

public class PlayEscala {

    public static void escalaMaior(int tonica) {
        int escala[] = { tonica, tonica+2, tonica+4, tonica+5, tonica+7, tonica+9, tonica+11, tonica+12 };
        System.out.println("Você está ouvindo a escala maior");
        play(escala);
    }

    public static void escalaMenorPrimitiva(int tonica) {
        int escala[] = { tonica, tonica+2, tonica+3, tonica+5, tonica+7, tonica+8, tonica+10, tonica+12 };
        System.out.println("Você está ouvindo a escala menor primitiva");
        play(escala);
    }
    
    public static void escalaMenorHarmonica(int tonica) {
        int escala[] = { tonica, tonica+2, tonica+3, tonica+5, tonica+7, tonica+8, tonica+11, tonica+12 };
        System.out.println("Você está ouvindo a escala menor harmônica");
        play(escala);
    }

    public static void escalaMenorMelodica(int tonica) {
        int escala[] = { tonica, tonica+2, tonica+3, tonica+5, tonica+7, tonica+9, tonica+11, tonica+12,
            tonica+10, tonica+8, tonica+7, tonica+5, tonica+3, tonica+2, tonica };
        System.out.println("Você está ouvindo a escala menor melódica");
        play(escala);
    }
    
    public static void play(int notes[]) {
        try {

            Synthesizer midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();

            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
            MidiChannel[] mChannels = midiSynth.getChannels();

            midiSynth.loadInstrument(instr[0]);

            for (int i = 0; i < notes.length; i++) {

                mChannels[0].noteOn(notes[i], 100);
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mChannels[0].noteOff(notes[i]);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }
    
}
