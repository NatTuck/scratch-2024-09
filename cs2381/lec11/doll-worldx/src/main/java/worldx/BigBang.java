/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                       *
 *   JavaWorld Library, Copyright 2011 Bryan Chadwick                    *
 *                                                                       *
 *   FILE: ./world/BigBang.java                                          *
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

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

/** A Class representing the creation of a World/System of some type, and the
 *    related methods and Function
 *    Objects (call-backs) for drawing the world and handling various events.  As
 *    handlers are installed, each is checked for a corresponding <tt>apply</tt>
 *    method with the appropriate signature.
 *    
 *  <p>The initial value of the World assigns a (minimum) <i>type</i>, which is
 *    used to search/check all of the handlers.  Functions that produce a world
 *    deserve special attention, since they may return a super-type of the
 *    initial World (e.g., initial <tt>EmptyScene</tt>, with an tick handler that
 *    returns a <tt>Scene</tt>).  The name and types of handlers are given in the
 *    table below:<br/><br/>
 *    
 *    <style>
 *       table.mine{ margin-left: 20px; border: 1px solid blue; }
 *       table.mine td, table.mine th{ padding-left:20px; padding-right:5px;  border: 1px solid blue; }
 *       td.event, th.event{ text-align: center; }
 *       .com { color: #AA240F; font-style: italic; }
 *       .keyw { color: #262680; font-weight: bold; }
 *       .useful { color: #1111C0; }
 *       .num { color: #00AA00; }
 *       .str { color: #00AA00; }
 *       .fun { color: #AA5500; }
 *    </style>
 *    <table class="mine">
 *      <tr><th class="event">Event Name</th><th>BigBang Method</th><th>Handler Signature</th><th>Required?</th><tr/>
 *      <tr><td class="event">OnDraw</td><td><tt><span class='fun'>onDraw</span>(<i>handler</i>)</tt></td><td><tt>Scene <span class='fun'>apply</span>(World w)</tt></td><td><b><i>yes</i></b></td><tr/>
 *      <tr><td class="event">OnTick</td><td><tt><span class='fun'>onTick</span>(<i>handler</i>)</tt> or<br/> <tt><span class='fun'>onTick</span>(<i>handler</i>, <span class="keyw">double</span>)</tt></td><td><tt>World <span class='fun'>apply</span>(World w)</tt></td><td>no</td><tr/>
 *      <tr><td class="event">OnMouse</td><td><tt><span class='fun'>onMouse</span>(<i>handler</i>)</tt></td><td><tt>World <span class='fun'>apply</span>(World w, <span class="keyw">int</span> x, <span class="keyw">int</span> y, String what)</tt></td><td>no</td><tr/>
 *      <tr><td class="event">OnKey</td><td><tt><span class='fun'>onKey</span>(<i>handler</i>)</tt></td><td><tt>World <span class='fun'>apply</span>(World w, String key)</tt></td><td>no</td><tr/>
 *      <tr><td class="event">OnRelease</td><td><tt><span class='fun'>onRelease</span>(<i>handler</i>)</tt></td><td><tt>World <span class='fun'>apply</span>(World w, String key)</tt></td><td>no</td><tr/>
 *      <tr><td class="event">StopWhen</td><td><tt><span class='fun'>stopWhen</span>(<i>handler</i>)</tt></td><td><tt><span class="keyw">boolean</span> <span class='fun'>apply</span>(World w)</tt></td><td>no</td><tr/>
 *      <tr><td class="event">LastScene</td><td><tt><span class='fun'>lastScene</span>(<i>handler</i>)</tt></td><td><tt>Scene <span class='fun'>apply</span>(World w)</tt></td><td>no</td><tr/>
 *    </table><br/>
 *    
 *    If a matching method is not found when installing handlers, a RuntimeException is
 *    thrown, describing the offense.
 *    </p>
 */
public class BigBang {
    /** Default Tick rate for the world: ~33 frames per second */
    public static double DEFAULT_TICKS_PER_SECOND = 30;

    /** Gap left around the border of the Window */
    private static int SPACE = 5;

    /** Construct and run the animation/interaction system.  For the
     *    Swing version the method returns the final value of the
     *    World after the animation has completed.  The Window is
     *    opened as a Modal dialog, so control does not return to the
     *    bigband caller until the window is closed. */
    public static World start(World world0, String title) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
            // pass
        }

        JDialog f = new JDialog((JFrame)null, title, true);
        Scene scn = world0.onDraw();

        int width = (int)(SPACE*2+Math.max(20, 14+scn.width()));
        int height = (int)(Math.max(20, SPACE * 2 + 31 + scn.height()));
        f.setSize(width, height);
        f.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        f.setResizable(false);

        var buff = new BufferedImage(
            (int) (scn.width() + 2 * SPACE), 
            (int) (scn.height() + 2 * SPACE),
            BufferedImage.TYPE_INT_RGB);

        var hh = new Handler(world0, scn, buff, f);
        f.getContentPane().add(hh);
        f.setVisible(true);
        hh.run.cancel();

        return hh.world;        
    }

    /** Handles the nitty-gritty of world updates and interfacing with Swing */
    static class Handler extends javax.swing.JComponent
                         implements MouseListener, KeyListener, MouseMotionListener {
        private static final long serialVersionUID = 1L;
        World world;
        Scene scnBuffer;
        BufferedImage buffer;
        Graphics2D graph;
        Timer run;
        TimerTask ticker;
        boolean isRunning = false;
        boolean isDone = false;
        
        /** Create a new Handler for all the World's events */
        Handler(World world0, Scene scn, BufferedImage buff, JDialog dia){
            this.world = world0;

            this.scnBuffer = null;
            this.buffer = buff;
            this.graph = buff.createGraphics();
            this.graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            this.graph.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
            this.run = new Timer();

            addMouseListener(this);
            addMouseMotionListener(this);
            dia.addKeyListener(this);
            this.isRunning = true;
            // TODO: Old version didn't tick for worlds without onTick handlers.
            this.run.scheduleAtFixedRate(this.ticker = new TimerTask() {
                public void run(){ tickAction(); }
            }, 200, (int)((1.0/world.ticksPerSecond()) * 1000));
        }

        /** Swing uses a <tt>paint(Graphics)</tt> method to draw the
         *    component (Handler) into the window. */
        public void paint(java.awt.Graphics g) {
            Scene curr;
            if(!this.isDone) {
                curr = this.world.onDraw();
            }
            else {
                curr = this.world.lastScene();
            }
            
            if(curr != this.scnBuffer){
                this.scnBuffer = curr;
                this.graph.setColor(Color.white);
                this.graph.fillRect(0,0, this.getWidth(), this.getHeight());
                this.graph.clipRect(SPACE, SPACE, this.buffer.getWidth()-SPACE*2, this.buffer.getHeight()-SPACE*2);
                this.scnBuffer.paint(this.graph,SPACE,SPACE);
            }
            g.drawImage(this.buffer, 0, 0, null);
        }

        /** Rather than Swing timers, we use to java.util.Timer to
         *    provide compatibility with Android (i.e., so the code
         *    for both versions looks the same). */
        public void tickAction() {
            if(!this.isRunning || this.isDone) {
                return;
            }
            replace(this.world.onTick());
        }

        public void mousePressed(final MouseEvent e){
            if (this.isRunning && !this.isDone) {
                replace(this.world.onMouse(e.getX(), e.getY(), "down"));
            }
        }

        /** Mouse click/move/event Methods */
        public void mouseClicked(MouseEvent e) {
            // pass
        }

        public void mouseEntered(MouseEvent e) {
            if (this.isRunning && !this.isDone) {
                replace(this.world.onMouse(e.getX(), e.getY(), "enter"));
            }
        }

        public void mouseExited(MouseEvent e) {
            if (this.isRunning && !this.isDone) {
                replace(this.world.onMouse(e.getX(), e.getY(), "leave"));
            }
        }

        public void mouseReleased(MouseEvent e) {
            if (this.isRunning && !this.isDone) {
                replace(this.world.onMouse(e.getX(), e.getY(), "up"));
            }
        }

        public void mouseDragged(MouseEvent e) {
            if (this.isRunning && !this.isDone) {
                replace(this.world.onMouse(e.getX(), e.getY(), "drag"));
            }
        }

        public void mouseMoved(MouseEvent e) {
            if (this.isRunning && !this.isDone) {
                replace(this.world.onMouse(e.getX(), e.getY(), "move"));
            }
        }

        /** Keys are converted to strings to simplify handling */
        public void keyPressed(KeyEvent e) {
            if (this.isRunning && !this.isDone) {
                replace(this.world.onKey(convert(e.getKeyCode(), "" + e.getKeyChar())));
            }
        }

        public void keyReleased(KeyEvent e) {
            if (this.isRunning && !this.isDone)
                replace(this.world.onKeyUp(convert(e.getKeyCode(), "" + e.getKeyChar())));
        }

        public void keyTyped(KeyEvent e) {
            // if(isRunning && !isDone)replace(world.doOnKeyEvent(w, ""+e.getKeyChar()));
        }

        private void replace(World w) {
            // This isn't enough when mutation is involved...
            if (!this.isRunning || this.isDone) {
                return;
            }

            if (this.isRunning && world.stopWhen()){
                this.isRunning = false;
                this.isDone = true;
                this.run.cancel();
            }
            
            boolean change = !this.world.equals(w);
            this.world = w;

            if (change) {
                repaint();
            }
        }

        private String convert(int code, String ch){
            switch (code) {
                case KeyEvent.VK_UP:
                    return "up";
                case KeyEvent.VK_DOWN:
                    return "down";
                case KeyEvent.VK_LEFT:
                    return "left";
                case KeyEvent.VK_RIGHT:
                    return "right";
                case KeyEvent.VK_ESCAPE:
                    return "esc";
                default:
                    return ch;
            }
        }

    }
}
