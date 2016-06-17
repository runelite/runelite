import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class221 {
   @ObfuscatedName("g")
   public static Comparator field3179 = new class218();
   @ObfuscatedName("eg")
   static class78[] field3180;
   @ObfuscatedName("j")
   public static Comparator field3181;
   @ObfuscatedName("x")
   public static Comparator field3182;
   @ObfuscatedName("d")
   public static Comparator field3184;
   @ObfuscatedName("b")
   public final List field3185;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZB)V",
      garbageValue = "-41"
   )
   public void method4020(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3185, var1);
      } else {
         Collections.sort(this.field3185, Collections.reverseOrder(var1));
      }

   }

   static {
      new class219();
      field3181 = new class217();
      field3184 = new class213();
      field3182 = new class216();
   }

   @ObfuscatedSignature(
      signature = "(Lclass119;Z)V",
      garbageValue = "1"
   )
   public class221(class119 var1, boolean var2) {
      int var3 = var1.method2516();
      boolean var4 = var1.method2514() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2516();
      this.field3185 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3185.add(new class214(var1, var5, var3));
      }

   }
}
