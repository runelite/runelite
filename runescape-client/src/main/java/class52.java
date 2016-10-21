import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class52 extends CacheableNode {
   @ObfuscatedName("v")
   public String field1125 = "null";
   @ObfuscatedName("t")
   public char field1126;
   @ObfuscatedName("e")
   static NodeCache field1127 = new NodeCache(64);
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = -519813653
   )
   static int field1128;
   @ObfuscatedName("n")
   public char field1129;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1297042699
   )
   public int field1130;
   @ObfuscatedName("f")
   static class170 field1131;
   @ObfuscatedName("k")
   public int[] field1132;
   @ObfuscatedName("c")
   public int[] field1133;
   @ObfuscatedName("w")
   public String[] field1134;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1776306705
   )
   public int field1135 = 0;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "16"
   )
   void method1071(Buffer var1) {
      while(true) {
         int var2 = var1.method2656();
         if(var2 == 0) {
            return;
         }

         this.method1073(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-398502586"
   )
   void method1073(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1129 = (char)var1.method2656();
      } else if(var2 == 2) {
         this.field1126 = (char)var1.method2656();
      } else if(var2 == 3) {
         this.field1125 = var1.method2541();
      } else if(var2 == 4) {
         this.field1130 = var1.method2538();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1135 = var1.method2535();
            this.field1132 = new int[this.field1135];
            this.field1134 = new String[this.field1135];

            for(var3 = 0; var3 < this.field1135; ++var3) {
               this.field1132[var3] = var1.method2538();
               this.field1134[var3] = var1.method2541();
            }
         } else if(var2 == 6) {
            this.field1135 = var1.method2535();
            this.field1132 = new int[this.field1135];
            this.field1133 = new int[this.field1135];

            for(var3 = 0; var3 < this.field1135; ++var3) {
               this.field1132[var3] = var1.method2538();
               this.field1133[var3] = var1.method2538();
            }
         }
      }

   }
}
