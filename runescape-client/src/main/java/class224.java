import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class224 {
   @ObfuscatedName("e")
   public static Comparator field3225 = new class221();
   @ObfuscatedName("n")
   public static Comparator field3226;
   @ObfuscatedName("t")
   public static Comparator field3227;
   @ObfuscatedName("f")
   public final List field3228;
   @ObfuscatedName("v")
   public static Comparator field3229;

   static {
      new class222();
      field3226 = new class220();
      field3227 = new class216();
      field3229 = new class219();
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class224(Buffer var1, boolean var2) {
      int var3 = var1.method2535();
      boolean var4 = var1.method2656() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2535();
      this.field3228 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3228.add(new class217(var1, var5, var3));
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-1997006250"
   )
   public void method4080(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3228, var1);
      } else {
         Collections.sort(this.field3228, Collections.reverseOrder(var1));
      }

   }
}
