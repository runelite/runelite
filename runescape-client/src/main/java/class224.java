import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class224 {
   @ObfuscatedName("l")
   public final List field3220;
   @ObfuscatedName("g")
   public static Comparator field3221 = new class221();
   @ObfuscatedName("r")
   public static Comparator field3222;
   @ObfuscatedName("e")
   public static Comparator field3223;
   @ObfuscatedName("h")
   public static Comparator field3224;
   @ObfuscatedName("w")
   static int[] field3225;

   static {
      new class222();
      field3222 = new class220();
      field3223 = new class216();
      field3224 = new class219();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "727245254"
   )
   public void method4159(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3220, var1);
      } else {
         Collections.sort(this.field3220, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass122;Z)V",
      garbageValue = "1"
   )
   public class224(class122 var1, boolean var2) {
      int var3 = var1.method2635();
      boolean var4 = var1.method2633() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2635();
      this.field3220 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3220.add(new class217(var1, var5, var3));
      }

   }
}
