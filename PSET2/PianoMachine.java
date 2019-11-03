// 22 Submissions, include part 1,2,3 & 4
package piano;

import java.util.ArrayList;
import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.NoteEvent;
import music.Pitch;

public class PianoMachine {

    private Midi midi;
    private Instrument ins = Instrument.PIANO;
    private ArrayList<Pitch> pitch_list = new ArrayList<>();
    private int octave = 0;
    private boolean recording = false;
    private ArrayList<NoteEvent> recorder_list = new ArrayList<>();

    /**
     * constructor for PianoMachine.
     * <p>
     * initialize midi device and any other state that we're storing.
     */
    public PianoMachine() {
        try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }

    //TODO write method spec
    public void beginNote(Pitch rawPitch) {
        //midi.beginNote(new Pitch(0).toMidiFrequency());
        //TODO implement for question 1
        Pitch octPitch = rawPitch.transpose(octave);
        if (!(pitch_list.contains(octPitch))) {
            midi.beginNote(octPitch.toMidiFrequency(), ins);
            pitch_list.add(octPitch);
        }
        if (recording) {
            NoteEvent current_session = new NoteEvent(octPitch, System.currentTimeMillis(), ins, NoteEvent.Kind.start);
            recorder_list.add(current_session);
        }
    }

    //TODO write method spec
    public void endNote(Pitch rawPitch) {
        //midi.endNote(new Pitch(0).toMidiFrequency());
        //TODO implement for question 1
        Pitch octPitch = rawPitch.transpose(octave);
        if (pitch_list.contains(octPitch)) {
            midi.endNote(octPitch.toMidiFrequency(), ins);
            pitch_list.remove(octPitch);
        }
        if (recording) {
            NoteEvent current_session = new NoteEvent(octPitch, System.currentTimeMillis(), ins, NoteEvent.Kind.stop);
            recorder_list.add(current_session);
        }
    }

    //TODO write method spec
    public void changeInstrument() {
        //TODO: implement for question 2
        ins = ins.next();
    }

    //TODO write method spec
    public void shiftUp() {
        //TODO: implement for question 3
        if (octave < 24) octave += 12;
    }

    //TODO write method spec
    public void shiftDown() {
        //TODO: implement for question 3
        if (octave > -24) octave -= 12;
    }

    public boolean toggleRecording() {
        if (recording)
            recording = false;
        else {
            recorder_list = new ArrayList<>();
            recording = true;
        }
        return recording;
    }

    //TODO write method spec
    public void playback() {
        //TODO: implement for question 4
        //long delay = 0;
        //long previous_time = recorder_list.get(0).getTime();
        long previous_time = 0;
        int output = 0;
        for (NoteEvent i : recorder_list) {
            long interval = i.getTime() - previous_time;
            output = (int) (interval / 10.0);
            midi.rest(output);
            if (i.getKind() == NoteEvent.Kind.start)
                midi.beginNote(i.getPitch().toMidiFrequency(), i.getInstr());
            else
                midi.endNote(i.getPitch().toMidiFrequency(), i.getInstr());
            previous_time = i.getTime();
        }
    }

}
