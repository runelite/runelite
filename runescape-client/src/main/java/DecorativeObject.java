import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 6163527
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -600112555
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1702253967
   )
   @Export("y")
   int y;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 332941917
   )
   int field1655;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 702729175
   )
   int field1656;
   @ObfuscatedName("m")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1648965213
   )
   int field1658;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 210422347
   )
   int field1659 = 0;
   @ObfuscatedName("p")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 147925111
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -574862199
   )
   int field1662;
   @ObfuscatedName("mc")
   static byte field1663;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = 181702409
   )
   static int field1666;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass171;IIIBZI)V",
      garbageValue = "-2024077180"
   )
   static void method2221(class171 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class175 var8 = (class175)class174.field2777.method3830(var6);
      if(null == var8) {
         var8 = (class175)class174.field2779.method3830(var6);
         if(null == var8) {
            var8 = (class175)class174.field2782.method3830(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3925();
                  class174.field2777.method3819(var8, var6);
                  --class174.field2786;
                  ++class174.field2794;
               }

            } else {
               if(!var5) {
                  var8 = (class175)class174.field2784.method3830(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class175();
               var8.field2797 = var0;
               var8.field2798 = var3;
               var8.field2801 = var4;
               if(var5) {
                  class174.field2777.method3819(var8, var6);
                  ++class174.field2794;
               } else {
                  class174.field2783.method3920(var8);
                  class174.field2782.method3819(var8, var6);
                  ++class174.field2786;
               }

            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)LFileOnDisk;",
      garbageValue = "-7"
   )
   public static FileOnDisk method2222(String var0, String var1, boolean var2) {
      File var3 = new File(class192.field3107, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(Frames.field1826 == 33) {
         var4 = "_rc";
      } else if(Frames.field1826 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class24.field620, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }
}
