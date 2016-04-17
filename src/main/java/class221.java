import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class221 {
   @ObfuscatedName("a")
   public final List field3176;
   @ObfuscatedName("w")
   public static Comparator field3177 = new class218();
   @ObfuscatedName("d")
   public static Comparator field3178;
   @ObfuscatedName("y")
   public static Comparator field3179;
   @ObfuscatedName("c")
   public static Comparator field3180;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "763490552"
   )
   public void method4099(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3176, var1);
      } else {
         Collections.sort(this.field3176, Collections.reverseOrder(var1));
      }

   }

   static {
      new class219();
      field3178 = new class217();
      field3180 = new class213();
      field3179 = new class216();
   }

   @ObfuscatedSignature(
      signature = "(Lclass119;Z)V",
      garbageValue = "1"
   )
   public class221(class119 var1, boolean var2) {
      int var3 = var1.method2615();
      boolean var4 = var1.method2613() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2615();
      this.field3176 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3176.add(new class214(var1, var5, var3));
      }

   }
}
