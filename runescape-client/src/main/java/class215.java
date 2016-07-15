import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class215 {
   @ObfuscatedName("c")
   static final class215 field3179 = new class215(8, 2, "", "");
   @ObfuscatedName("e")
   public static final class215 field3180 = new class215(1, 0, "", "");
   @ObfuscatedName("h")
   static final class215 field3181 = new class215(3, 3, "", "");
   @ObfuscatedName("l")
   static final class215 field3182 = new class215(0, 1, "", "");
   @ObfuscatedName("r")
   static final class215 field3183 = new class215(2, 4, "", "");
   @ObfuscatedName("a")
   static final class215 field3184 = new class215(7, 5, "", "");
   @ObfuscatedName("b")
   static final class215 field3185 = new class215(6, 6, "", "");
   @ObfuscatedName("u")
   static final class215 field3186 = new class215(5, 7, "", "");
   @ObfuscatedName("o")
   public static final class215 field3187;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1581399101
   )
   public final int field3188;
   @ObfuscatedName("i")
   final String field3189;

   public String toString() {
      return this.field3189;
   }

   class215(int var1, int var2, String var3, String var4) {
      this.field3188 = var1;
      this.field3189 = var4;
   }

   class215(int var1, int var2, String var3, String var4, boolean var5, class215[] var6) {
      this.field3188 = var1;
      this.field3189 = var4;
   }

   static {
      field3187 = new class215(4, -1, "", "", true, new class215[]{field3180, field3182, field3179, field3183, field3181});
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "91"
   )
   static void method4022(int var0, String var1) {
      int var2 = class34.field804;
      int[] var3 = class34.field807;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         class2 var6 = client.field467[var3[var5]];
         if(null != var6 && var6 != class118.field2035 && var6.field52 != null && var6.field52.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               client.field336.method2854(32);
               client.field336.method2795(0);
               client.field336.method2781(var3[var5]);
            } else if(var0 == 4) {
               client.field336.method2854(222);
               client.field336.method2635(0);
               client.field336.method2781(var3[var5]);
            } else if(var0 == 6) {
               client.field336.method2854(136);
               client.field336.method2642(var3[var5]);
               client.field336.method2635(0);
            } else if(var0 == 7) {
               client.field336.method2854(162);
               client.field336.method2635(0);
               client.field336.method2781(var3[var5]);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class25.method586(4, "", "Unable to find " + var1);
      }

   }
}
