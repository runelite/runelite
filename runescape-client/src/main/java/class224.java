import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class224 {
   @ObfuscatedName("c")
   public static Comparator field3219;
   @ObfuscatedName("l")
   public static Comparator field3220 = new class221();
   @ObfuscatedName("e")
   public final List field3221;
   @ObfuscatedName("h")
   public static Comparator field3222;
   @ObfuscatedName("r")
   public static Comparator field3223;

   static {
      new class222();
      field3219 = new class220();
      field3222 = new class216();
      field3223 = new class219();
   }

   @ObfuscatedSignature(
      signature = "(Lclass122;Z)V",
      garbageValue = "1"
   )
   public class224(class122 var1, boolean var2) {
      int var3 = var1.method2612();
      boolean var4 = var1.method2610() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2612();
      this.field3221 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3221.add(new class217(var1, var5, var3));
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZS)V",
      garbageValue = "-2764"
   )
   public void method4097(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3221, var1);
      } else {
         Collections.sort(this.field3221, Collections.reverseOrder(var1));
      }

   }
}
