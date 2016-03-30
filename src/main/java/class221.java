import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hz")
public class class221 {
   @ObfuscatedName("w")
   public final List field3179;
   @ObfuscatedName("x")
   public static Comparator field3180 = new class218();
   @ObfuscatedName("t")
   public static Comparator field3181;
   @ObfuscatedName("p")
   public static Comparator field3182;
   @ObfuscatedName("e")
   public static Comparator field3183;

   @ObfuscatedName("w")
   public void method4019(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3179, var1);
      } else {
         Collections.sort(this.field3179, Collections.reverseOrder(var1));
      }

   }

   public class221(class119 var1, boolean var2) {
      int var3 = var1.method2508();
      boolean var4 = var1.method2506() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2508();
      this.field3179 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3179.add(new class214(var1, var5, var3));
      }

   }

   static {
      new class219();
      field3181 = new class217();
      field3182 = new class213();
      field3183 = new class216();
   }
}
