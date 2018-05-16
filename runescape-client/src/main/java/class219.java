import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
public class class219 extends Node {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   class216 field2533;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 54965407
   )
   int field2518;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   class221 field2519;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lcg;"
   )
   RawAudioNode field2524;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 590821665
   )
   int field2522;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1792039957
   )
   int field2523;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1975788915
   )
   int field2535;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 660414507
   )
   int field2525;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -9681717
   )
   int field2526;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 500302173
   )
   int field2521;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1656532073
   )
   int field2528;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -746273245
   )
   int field2529;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 71023109
   )
   int field2530;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -98888263
   )
   int field2531;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 915092107
   )
   int field2532;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1256445999
   )
   int field2527;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -482545519
   )
   int field2534;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2144321905
   )
   int field2520;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   class103 field2536;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1726212601
   )
   int field2537;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -667928703
   )
   int field2538;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "569296590"
   )
   void method4360() {
      this.field2519 = null;
      this.field2524 = null;
      this.field2533 = null;
      this.field2536 = null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lbb;Lbb;IZB)I",
      garbageValue = "74"
   )
   static int method4361(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1606()?(var1.method1606()?0:1):(var1.method1606()?-1:0)):(var2 == 5?(var0.method1629()?(var1.method1629()?0:1):(var1.method1629()?-1:0)):(var2 == 6?(var0.method1605()?(var1.method1605()?0:1):(var1.method1605()?-1:0)):(var2 == 7?(var0.method1603()?(var1.method1603()?0:1):(var1.method1603()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-868634685"
   )
   public static final void method4362() {
      class120.Viewport_containsMouse = false;
      class120.Viewport_entityCountAtMouse = 0;
   }
}
