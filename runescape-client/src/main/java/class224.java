import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class224 {
   @ObfuscatedName("i")
   public final List field3230;
   @ObfuscatedName("h")
   public static Comparator field3231 = new class221();
   @ObfuscatedName("e")
   public static Comparator field3232;
   @ObfuscatedName("g")
   public static Comparator field3233;
   @ObfuscatedName("n")
   public static Comparator field3235;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZB)V",
      garbageValue = "24"
   )
   public void method4046(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3230, var1);
      } else {
         Collections.sort(this.field3230, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class224(Buffer var1, boolean var2) {
      int var3 = var1.method2546();
      boolean var4 = var1.method2544() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2546();
      this.field3230 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3230.add(new class217(var1, var5, var3));
      }

   }

   static {
      new class222();
      field3232 = new class220();
      field3233 = new class216();
      field3235 = new class219();
   }
}
