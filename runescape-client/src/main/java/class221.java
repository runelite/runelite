import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class221 {
   @ObfuscatedName("d")
   public static Comparator field3180;
   @ObfuscatedName("j")
   public static Comparator field3181 = new class218();
   @ObfuscatedName("x")
   public static Comparator field3182;
   @ObfuscatedName("s")
   public final List field3183;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -236949879
   )
   public static int field3184;
   @ObfuscatedName("p")
   public static Comparator field3185;

   static {
      new class219();
      field3185 = new class217();
      field3182 = new class213();
      field3180 = new class216();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZS)V",
      garbageValue = "-7842"
   )
   public void method3985(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3183, var1);
      } else {
         Collections.sort(this.field3183, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass119;Z)V",
      garbageValue = "1"
   )
   public class221(class119 var1, boolean var2) {
      int var3 = var1.method2584();
      boolean var4 = var1.method2492() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2584();
      this.field3183 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3183.add(new class214(var1, var5, var3));
      }

   }
}
