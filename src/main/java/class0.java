import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class0 extends class207 {
   @ObfuscatedName("n")
   String field0;
   @ObfuscatedName("r")
   boolean field1;
   @ObfuscatedName("g")
   class172 field2;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1491727289
   )
   int field3;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1359249209
   )
   int field4;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 475977805
   )
   int field5;
   @ObfuscatedName("f")
   class172 field6;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1807327173
   )
   int field7;
   @ObfuscatedName("a")
   Object[] field8;
   @ObfuscatedName("l")
   int field9;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -337968591
   )
   int field10;
   @ObfuscatedName("u")
   public static String[] field12;

   @ObfuscatedName("e")
   public static class78 method0(class166 var0, String var1, String var2) {
      int var3 = var0.method3278(var1);
      int var4 = var0.method3328(var3, var2);
      class78 var5;
      if(!class12.method176(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class16.method201();
      }

      return var5;
   }

   @ObfuscatedName("a")
   public static void method1(class166 var0) {
      class47.field1064 = var0;
   }

   @ObfuscatedName("a")
   public static void method2() {
      class210.field3125 = new class201();
   }

   @ObfuscatedName("l")
   public static boolean method3(class166 var0, int var1) {
      byte[] var2 = var0.method3268(var1);
      if(var2 == null) {
         return false;
      } else {
         class77.method1725(var2);
         return true;
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1187846587"
   )
   static final void method4(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field497; ++var4) {
         if(client.field504[var4] + client.field502[var4] > var0 && client.field502[var4] < var2 + var0 && client.field505[var4] + client.field515[var4] > var1 && client.field515[var4] < var3 + var1) {
            client.field500[var4] = true;
         }
      }

   }

   @ObfuscatedName("f")
   static void method5(int var0, String var1, String var2, String var3) {
      class27 var4 = (class27)class11.field169.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new class27();
         class11.field169.put(Integer.valueOf(var0), var4);
      }

      class35 var5 = var4.method641(var0, var1, var2, var3);
      class11.field164.method3847(var5, (long)var5.field789);
      class11.field165.method3882(var5);
      client.field486 = client.field479;
   }

   @ObfuscatedName("n")
   static byte[] method6(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }
}
