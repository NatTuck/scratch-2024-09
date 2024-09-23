/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                       *
 *   worldx changes by Nat Tuck, 2024                                    *
 *                                                                       *
 *   JavaWorld Library, Copyright 2011 Bryan Chadwick                    *
 *                                                                       *
 *   FILE: ./world/World.java                                            *
 *                                                                       *
 *   This file is part of JavaWorld.                                     *
 *                                                                       *
 *   JavaWorld is free software: you can redistribute it and/or          *
 *   modify it under the terms of the GNU General Public License         *
 *   as published by the Free Software Foundation, either version        *
 *   3 of the License, or (at your option) any later version.            *
 *                                                                       *
 *   JavaWorld is distributed in the hope that it will be useful,        *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of      *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the       *
 *   GNU General Public License for more details.                        *
 *                                                                       *
 *   You should have received a copy of the GNU General Public License   *
 *   along with JavaWorld.  If not, see <http://www.gnu.org/licenses/>.  *
 *                                                                       *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package worldx;

public interface World {
    /** Return a visualization of this <tt>World</tt> as a {@link image.Scene Scene}.
     *    See {@link image.EmptyScene}, {@link image.Scene#placeImage(Image, int, int)}, and
     *    {@link image.Scene#addLine(int, int, int, int, String)} for documentation on
     *    constructing <tt>Scene</tt>s */
    Scene onDraw();
    
    default double ticksPerSecond() {
        if (this.methodStillDefault("tickTime")) {
            return BigBang.DEFAULT_TICKS_PER_SECOND;
        }
        else {
            return 1.0 / this.tickTime();
        }
    }

    default double tickTime() {
        if (this.methodStillDefault("ticksPerSecond")) {
            return 1.0 / BigBang.DEFAULT_TICKS_PER_SECOND;
        }
        else {
            return 1.0 / this.ticksPerSecond();
        }
    }

    private boolean methodStillDefault(String name) {
        try {
            return this.getClass().getMethod(name).getDeclaringClass() == World.class;
        } catch (Exception _e) {
            return false;
        }
    }
    
    /** Produce a (possibly) new World based on the Tick of the clock.
     *  This method is called to get the <i>next world</i> on each
     *  clock tick.*/
    default World onTick() { 
        return this; 
    }
    
    /** Produce a (possibly) new World when a mouse event is
     * triggered.  <tt>x</tt> and <tt>y</tt> are the location of the
     * event in the window, and <tt>event</tt> is a <tt>String</tt>
     * that describes what kind of event occurred.
     * 
     * <p>
     *   <b>Possible Mouse Events</b>
     * <table class='events'>
     *    <tr><td style="text-align:right"><tt class='str'>"button-down"</tt> : </td>
     *        <td>The user <i>presses</i> a mouse button in the World window</td></tr>
     *    <tr><td style="text-align:right"><tt class='str'>"button-up"</tt> : </td>
     *        <td>The user <i>releases</i> a mouse button in the World window</td></tr>
     *    <tr><td style="text-align:right"><tt class='str'>"move"</tt> : </td>
     *        <td>The user <i>moves</i> the mouse in the World window</td></tr>
     *    <tr><td style="text-align:right"><tt class='str'>"drag"</tt> : </td>
     *        <td>The user <i>holds</i> a mouse button and <i>moves</i> the mouse in the World window</td></tr>
     *    <tr><td style="text-align:right"><tt class='str'>"enter"</tt> : </td>
     *        <td>The user moves the mouse <i>in-to</i> the World window</td></tr>
     *    <tr><td style="text-align:right"><tt class='str'>"leave"</tt> : </td>
     *        <td>The user moves the mouse <i>out-of</i> the World window</td></tr>
     * </table>
     * </p>
     */
    default World onMouse(int x, int y, String event) { 
        return this; 
    }
    
    /** Produce a (possibly) new World when a key is
     * pressed. The given <tt>event</tt> is a <tt>String</tt> that
     * describes what key was pressed.
     *
     * <p>
     *   <b>Special Keys</b>
     * <table class='events'>
     *    <tr><td style="text-align:right"><tt class='str'>"up"</tt> : </td>
     *        <td>The user presses the <i>up-arrow</i> key</td></tr>
     *    <tr><td style="text-align:right"><tt class='str'>"down"</tt> : </td>
     *        <td>The user presses the <i>down-arrow</i> key</td></tr>
     *    <tr><td style="text-align:right"><tt class='str'>"left"</tt> : </td>
     *        <td>The user presses the <i>left-arrow</i> key</td></tr>
     *    <tr><td style="text-align:right"><tt class='str'>"right"</tt> : </td>
     *        <td>The user presses the <i>right-arrow</i> key</td></tr>
     * </table>
     *
     * Other keys generate a single character <tt>String</tt> that
     * represents the key pressed. For example, Pressing the <i>B</i>
     * key on the keyboard generates <tt class='str'>"b"</tt> as an
     * event.  If the shift key is held while pressing <i>B</i> then
     * <tt class='str'>"B"</tt> is generated.  </p>
     */
    default World onKey(String event) { 
        return this; 
    }
    
    /** Produce a (possibly) new World when a key is released. The given <tt>event</tt>
     * is a <tt>String</tt> that describes which key was released.
     *
     * <p>
     *   <b>Special Keys</b>
     * <table class='events'>
     *    <tr><td style="text-align:right"><tt class='str'>"up"</tt> : </td>
     *        <td>The user presses the <i>up-arrow</i> key</td></tr>
     *    <tr><td style="text-align:right"><tt class='str'>"down"</tt> : </td>
     *        <td>The user presses the <i>down-arrow</i> key</td></tr>
     *    <tr><td style="text-align:right"><tt class='str'>"left"</tt> : </td>
     *        <td>The user presses the <i>left-arrow</i> key</td></tr>
     *    <tr><td style="text-align:right"><tt class='str'>"right"</tt> : </td>
     *        <td>The user presses the <i>right-arrow</i> key</td></tr>
     * </table>
     *
     * Other keys generate a single character <tt>String</tt> that
     * represents the key <i>released</i>. For example, Pressing then
     * releasing the <i>B</i> key on the keyboard generates <tt
     * class='str'>"b"</tt> as an <tt>onKey</tt> event and again as an
     * <tt>onRelease</tt> event.  If the shift key is held while
     * pressing/releasing <i>B</i> then <tt class='str'>"B"</tt> is
     * generated.  </p>
     */
    default World onKeyUp(String event) { 
        return this; 
    }
    
    /** Determine if the World/interaction/animation should be
     * stopped.  Returning a value of <tt class='keyw'>true</tt>
     * discontinues all events (mouse, key, ticks) and causes {@link
     * world.World#lastScene} to be used to draw the final
     * <tt>Scene</tt>.
     */
    default boolean stopWhen() { 
        return false; 
    }
    
    /** Returns the <tt>Scene</tt> that should be displayed when the
     * interaction/animation completes ({@link world.World#stopWhen}
     * returns <tt class='keyw'>true</tt>). */
    default Scene lastScene() { 
        return this.onDraw(); 
    }
    
    /** Kick off the interaction/animation.  This method returns the final
     *  state of the world after the user closes the World window. */
    default World start(String title) {
        return BigBang.start(this, title);
    }
}


