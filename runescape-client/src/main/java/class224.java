import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public class class224 {
   @ObfuscatedName("g")
   public static Comparator field3223;
   @ObfuscatedName("m")
   public final List field3224;
   @ObfuscatedName("e")
   public static Comparator field3225;
   @ObfuscatedName("o")
   public static Comparator field3226;
   @ObfuscatedName("w")
   public static Comparator field3227 = new class221();
   @ObfuscatedName("k")
   @Export("worldServersDownload")
   static class18 field3228;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)Ljava/lang/String;",
      garbageValue = "1"
   )
   public static String method4081(class122 var0) {
      String var1;
      try {
         int var2 = var0.method2585();
         if(var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.field2045 += class225.field3230.method2501(var0.field2047, var0.field2045, var3, 0, var2);
         String var4 = class7.method106(var3, 0, var2);
         var1 = var4;
      } catch (Exception var6) {
         var1 = "Cabbage";
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-2119555947"
   )
   public void method4082(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3224, var1);
      } else {
         Collections.sort(this.field3224, Collections.reverseOrder(var1));
      }

   }

   static {
      new class222();
      field3225 = new class220();
      field3226 = new class216();
      field3223 = new class219();
   }

   @ObfuscatedSignature(
      signature = "(Lclass122;Z)V",
      garbageValue = "1"
   )
   public class224(class122 var1, boolean var2) {
      int var3 = var1.method2706();
      boolean var4 = var1.method2556() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2706();
      this.field3224 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3224.add(new class217(var1, var5, var3));
      }

   }
}
