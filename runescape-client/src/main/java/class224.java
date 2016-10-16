import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class224 {
   @ObfuscatedName("p")
   public static Comparator field3225;
   @ObfuscatedName("z")
   public static Comparator field3226 = new class221();
   @ObfuscatedName("t")
   public static Comparator field3227;
   @ObfuscatedName("y")
   public static Comparator field3228;
   @ObfuscatedName("s")
   public final List field3229;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-911301471"
   )
   public void method4011(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3229, var1);
      } else {
         Collections.sort(this.field3229, Collections.reverseOrder(var1));
      }

   }

   static {
      new class222();
      field3227 = new class220();
      field3228 = new class216();
      field3225 = new class219();
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class224(Buffer var1, boolean var2) {
      int var3 = var1.method2668();
      boolean var4 = var1.method2481() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2668();
      this.field3229 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3229.add(new class217(var1, var5, var3));
      }

   }
}
