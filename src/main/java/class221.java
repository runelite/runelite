import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hg")
public class class221 {
   @ObfuscatedName("s")
   public static Comparator field3173;
   @ObfuscatedName("w")
   public static Comparator field3174 = new class218();
   @ObfuscatedName("f")
   public static Comparator field3175;
   @ObfuscatedName("e")
   public final List field3176;
   @ObfuscatedName("p")
   public static Comparator field3177;
   @ObfuscatedName("nk")
   static class56 field3179;

   @ObfuscatedName("e")
   public void method3998(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3176, var1);
      } else {
         Collections.sort(this.field3176, Collections.reverseOrder(var1));
      }

   }

   public class221(class119 var1, boolean var2) {
      int var3 = var1.method2700();
      boolean var4 = var1.method2523() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2700();
      this.field3176 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3176.add(new class214(var1, var5, var3));
      }

   }

   static {
      new class219();
      field3175 = new class217();
      field3173 = new class213();
      field3177 = new class216();
   }
}
