package net.runelite.rs.client;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cv")
public final class class86 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2115671315
   )
   int field1526;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1563287113
   )
   int field1527;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 837353951
   )
   int field1528;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -270660157
   )
   int field1529;
   @ObfuscatedName("m")
   public class84 field1530;
   @ObfuscatedName("o")
   public class84 field1531;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -761083041
   )
   public int field1532 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -959220627
   )
   int field1533 = 0;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 1015186923
   )
   protected static int field1534;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1536424703
   )
   int field1535;

   @ObfuscatedName("h")
   public static void method2048() {
      if(class216.field3155 != null) {
         class216.field3155.method2948();
      }

   }

   @ObfuscatedName("o")
   static int method2049(int var0, int var1, int var2) {
      return (class5.field81[var0][var1][var2] & 8) != 0?0:(var0 > 0 && 0 != (class5.field81[1][var1][var2] & 2)?var0 - 1:var0);
   }

   @ObfuscatedName("a")
   public static boolean method2050(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("j")
   static boolean method2051() {
      try {
         if(null == class216.field3156) {
            class216.field3156 = new class18(class26.field648, new URL(client.field294));
         } else {
            byte[] var0 = class216.field3156.method197();
            if(var0 != null) {
               class118 var1 = new class118(var0);
               class25.field633 = var1.method2455();
               class25.field632 = new class25[class25.field633];

               class25 var3;
               for(int var2 = 0; var2 < class25.field633; var3.field642 = var2++) {
                  var3 = class25.field632[var2] = new class25();
                  var3.field637 = var1.method2455();
                  var3.field638 = var1.method2458();
                  var3.field640 = var1.method2461();
                  var3.field641 = var1.method2461();
                  var3.field635 = var1.method2453();
                  var3.field639 = var1.method2558();
               }

               class23.method591(class25.field632, 0, class25.field632.length - 1, class25.field636, class25.field645);
               class216.field3156 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class216.field3156 = null;
      }

      return false;
   }
}
