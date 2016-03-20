import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hq")
public class class220 {
   @ObfuscatedName("a")
   public final List field3169;
   @ObfuscatedName("r")
   public static Comparator field3170 = new class217();
   @ObfuscatedName("s")
   public static Comparator field3171;
   @ObfuscatedName("f")
   public static Comparator field3172;
   @ObfuscatedName("y")
   public static Comparator field3173;
   @ObfuscatedName("em")
   static class80[] field3174;

   static {
      new class218();
      field3172 = new class216();
      field3171 = new class212();
      field3173 = new class215();
   }

   @ObfuscatedName("a")
   public void method4045(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3169, var1);
      } else {
         Collections.sort(this.field3169, Collections.reverseOrder(var1));
      }

   }

   public class220(class118 var1, boolean var2) {
      int var3 = var1.method2514();
      boolean var4 = var1.method2579() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2514();
      this.field3169 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3169.add(new class213(var1, var5, var3));
      }

   }
}
