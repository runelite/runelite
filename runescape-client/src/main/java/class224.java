import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
public class class224 {
   @ObfuscatedName("j")
   public static Comparator field3224;
   @ObfuscatedName("r")
   public static Comparator field3225 = new class221();
   @ObfuscatedName("x")
   public final List field3226;
   @ObfuscatedName("z")
   public static Comparator field3227;
   @ObfuscatedName("i")
   public static Comparator field3228;

   static {
      new class222();
      field3224 = new class220();
      field3227 = new class216();
      field3228 = new class219();
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class224(Buffer var1, boolean var2) {
      int var3 = var1.method2551();
      boolean var4 = var1.method2556() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2551();
      this.field3226 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3226.add(new class217(var1, var5, var3));
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-233467785"
   )
   public void method4031(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3226, var1);
      } else {
         Collections.sort(this.field3226, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "1409289709"
   )
   static String method4032(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class137.method2916(class8.method112(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var4 = "";
            if(class141.field2189 != null) {
               var4 = Tile.method2342(class141.field2189.field2272);
               if(null != class141.field2189.field2270) {
                  var4 = (String)class141.field2189.field2270;
               }
            }

            var0 = var0.substring(0, var2) + var4 + var0.substring(4 + var2);
         }
      }

      return var0;
   }
}
