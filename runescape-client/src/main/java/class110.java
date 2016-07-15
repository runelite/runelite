import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public abstract class class110 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1648799709
   )
   public int field1949;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -60112423
   )
   public int field1951;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2020126685
   )
   public int field1952;
   @ObfuscatedName("z")
   static int[] field1954;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -81078169
   )
   public int field1955;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIILclass111;S)Z",
      garbageValue = "-16645"
   )
   public abstract boolean vmethod2464(int var1, int var2, int var3, class111 var4);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Lclass230;",
      garbageValue = "-1681339235"
   )
   public static class230 method2465(String var0, String var1, boolean var2) {
      File var3 = new File(class152.field2281, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            class230 var10 = new class230(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class30.field726 == 33) {
         var4 = "_rc";
      } else if(class30.field726 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class12.field197, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      class230 var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new class230(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new class230(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("l")
   static final void method2467(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method2469() {
      if(class31.field744 != null) {
         class31.field744.method1277();
      }

      if(class34.field809 != null) {
         class34.field809.method1277();
      }

   }
}
