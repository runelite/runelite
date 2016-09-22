import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class34 {
   @ObfuscatedName("v")
   static byte[] field776 = new byte[2048];
   @ObfuscatedName("r")
   static byte[] field777 = new byte[2048];
   @ObfuscatedName("z")
   static Buffer[] field778 = new Buffer[2048];
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 545011847
   )
   static int field779 = 0;
   @ObfuscatedName("n")
   static int[] field780 = new int[2048];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 79153805
   )
   static int field781 = 0;
   @ObfuscatedName("g")
   static int[] field782 = new int[2048];
   @ObfuscatedName("x")
   static int[] field785 = new int[2048];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 790183143
   )
   static int field786 = 0;
   @ObfuscatedName("j")
   static int[] field787 = new int[2048];
   @ObfuscatedName("k")
   static int[] field788 = new int[2048];
   @ObfuscatedName("q")
   static Buffer field792 = new Buffer(new byte[5000]);
   @ObfuscatedName("m")
   static int[] field794 = new int[2048];

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass171;IIIBZI)V",
      garbageValue = "627028361"
   )
   static void method745(class171 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class175 var8 = (class175)class174.field2791.method3817(var6);
      if(null == var8) {
         var8 = (class175)class174.field2799.method3817(var6);
         if(null == var8) {
            var8 = (class175)class174.field2787.method3817(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3938();
                  class174.field2791.method3823(var8, var6);
                  --class174.field2788;
                  ++class174.field2783;
               }

            } else {
               if(!var5) {
                  var8 = (class175)class174.field2784.method3817(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class175();
               var8.field2805 = var0;
               var8.field2801 = var3;
               var8.field2802 = var4;
               if(var5) {
                  class174.field2791.method3823(var8, var6);
                  ++class174.field2783;
               } else {
                  class174.field2780.method3925(var8);
                  class174.field2787.method3823(var8, var6);
                  ++class174.field2788;
               }

            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "148"
   )
   public static void method746(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class140.keyboard);
      var0.addFocusListener(class140.keyboard);
   }
}
