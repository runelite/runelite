import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("j")
   @Export("osName")
   static String osName;
   @ObfuscatedName("ad")
   static int[] field1571;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1633509945
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 1627967619
   )
   static int field1575;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Ldd;"
   )
   @Export("systems")
   volatile AbstractSoundSystem[] systems;

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            AbstractSoundSystem var2 = this.systems[var1];
            if(var2 != null) {
               var2.method2078();
            }
         }
      } catch (Exception var4) {
         Bounds.method5132((String)null, var4);
      }

   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(Lhq;IIII)V",
      garbageValue = "1144394787"
   )
   static final void method2131(Widget var0, int var1, int var2, int var3) {
      class221 var4 = var0.method4209(false);
      if(var4 != null) {
         if(Client.field1089 < 3) {
            VarPlayerType.compass.method5293(var1, var2, var4.field2721, var4.field2718, 25, 25, Client.mapAngle, 256, var4.field2720, var4.field2719);
         } else {
            Rasterizer2D.method5172(var1, var2, 0, var4.field2720, var4.field2719);
         }

      }
   }
}
