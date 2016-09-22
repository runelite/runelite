import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class224 {
   @ObfuscatedName("r")
   public static Comparator field3223;
   @ObfuscatedName("d")
   public static Comparator field3224 = new class221();
   @ObfuscatedName("z")
   public static Comparator field3225;
   @ObfuscatedName("v")
   public static Comparator field3226;
   @ObfuscatedName("a")
   public final List field3227;
   @ObfuscatedName("j")
   static int[] field3228;

   static {
      new class222();
      field3226 = new class220();
      field3223 = new class216();
      field3225 = new class219();
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class224(Buffer var1, boolean var2) {
      int var3 = var1.method2717();
      boolean var4 = var1.method2528() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2717();
      this.field3227 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3227.add(new class217(var1, var5, var3));
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "404338508"
   )
   public void method4056(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3227, var1);
      } else {
         Collections.sort(this.field3227, Collections.reverseOrder(var1));
      }

   }
}
