import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
public class class221 {
   @ObfuscatedName("j")
   public final List field3179;
   @ObfuscatedName("m")
   public static Comparator field3180;
   @ObfuscatedName("h")
   public static Comparator field3181 = new class218();
   @ObfuscatedName("z")
   public static Comparator field3182;
   @ObfuscatedName("x")
   public static Comparator field3183;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-72499006"
   )
   public void method3992(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3179, var1);
      } else {
         Collections.sort(this.field3179, Collections.reverseOrder(var1));
      }

   }

   static {
      new class219();
      field3180 = new class217();
      field3182 = new class213();
      field3183 = new class216();
   }

   @ObfuscatedSignature(
      signature = "(Lclass119;Z)V",
      garbageValue = "1"
   )
   public class221(class119 var1, boolean var2) {
      int var3 = var1.method2502();
      boolean var4 = var1.method2500() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2502();
      this.field3179 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3179.add(new class214(var1, var5, var3));
      }

   }
}
