import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class9 {
   @ObfuscatedName("u")
   static int[] field144;
   @ObfuscatedName("x")
   static final BigInteger field146 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("y")
   static final BigInteger field147 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -1044107651
   )
   protected static int field150;
   @ObfuscatedName("at")
   static class146 field153;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "1"
   )
   public static int method117(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var1 * var5;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "([Lclass173;Lclass173;ZI)V",
      garbageValue = "-2078822482"
   )
   static void method121(class173[] var0, class173 var1, boolean var2) {
      int var3 = var1.field2771 != 0?var1.field2771:var1.field2763;
      int var4 = var1.field2772 != 0?var1.field2772:var1.field2764;
      class52.method1074(var0, var1.field2748, var3, var4, var2);
      if(null != var1.field2872) {
         class52.method1074(var1.field2872, var1.field2748, var3, var4, var2);
      }

      class3 var5 = (class3)client.field448.method3807((long)var1.field2748);
      if(var5 != null) {
         class85.method1921(var5.field60, var3, var4, var2);
      }

      if(var1.field2768 == 1337) {
         ;
      }

   }
}
