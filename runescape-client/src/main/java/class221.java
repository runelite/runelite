import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class221 {
   @ObfuscatedName("u")
   public static Comparator field3174 = new class218();
   @ObfuscatedName("b")
   public static Comparator field3175;
   @ObfuscatedName("f")
   public final List field3176;
   @ObfuscatedName("x")
   public static Comparator field3177;
   @ObfuscatedName("l")
   public static Comparator field3178;

   @ObfuscatedSignature(
      signature = "(Lclass119;Z)V",
      garbageValue = "1"
   )
   public class221(class119 var1, boolean var2) {
      int var3 = var1.method2556();
      boolean var4 = var1.method2554() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2556();
      this.field3176 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3176.add(new class214(var1, var5, var3));
      }

   }

   static {
      new class219();
      field3177 = new class217();
      field3175 = new class213();
      field3178 = new class216();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-1434311266"
   )
   public void method4035(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3176, var1);
      } else {
         Collections.sort(this.field3176, Collections.reverseOrder(var1));
      }

   }
}
