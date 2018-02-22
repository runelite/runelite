import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1325188357
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1510425619
   )
   @Export("count")
   int count;
   @ObfuscatedName("o")
   @Export("types")
   int[] types;
   @ObfuscatedName("p")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "-985057531"
   )
   static void method2880(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class56.field616.startsWith("win") && !var3) {
            class19.method147(var0, 0);
            return;
         }

         if(class56.field616.startsWith("mac")) {
            KitDefinition.method4832(var0, 1, var2);
            return;
         }

         class19.method147(var0, 2);
      } else {
         class19.method147(var0, 3);
      }

   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "17"
   )
   static final void method2881(int var0, int var1) {
      if(class2.loadWidget(var0)) {
         ScriptEvent.method1138(Widget.widgets[var0], var1);
      }
   }
}
