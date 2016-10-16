import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class13 implements Runnable {
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 478773107
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("z")
   Object field185 = new Object();
   @ObfuscatedName("y")
   int[] field186 = new int[500];
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -804028339
   )
   int field187 = 0;
   @ObfuscatedName("p")
   int[] field188 = new int[500];
   @ObfuscatedName("s")
   boolean field189 = true;

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-1790210657"
   )
   static boolean method164(Widget var0) {
      if(Client.field438) {
         if(class11.method138(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   public void run() {
      for(; this.field189; class16.method185(50L)) {
         Object var1 = this.field185;
         synchronized(this.field185) {
            if(this.field187 < 500) {
               this.field186[this.field187] = class143.field2192;
               this.field188[this.field187] = class143.field2189;
               ++this.field187;
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "-1509244084"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field968.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = GroundObject.method2150(class93.field1607, Sequence.field966, var0, false);
         if(var1 != null) {
            Sequence.field968.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
