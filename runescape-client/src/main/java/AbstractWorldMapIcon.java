import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("AbstractWorldMapIcon")
public abstract class AbstractWorldMapIcon {
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -1942470229
   )
   @Export("__ak_qj")
   static int __ak_qj;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -1734004743
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("coord2")
   public final TileLocation coord2;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("coord1")
   public final TileLocation coord1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -521086143
   )
   @Export("__e")
   int __e;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1065362217
   )
   @Export("__x")
   int __x;

   @ObfuscatedSignature(
      signature = "(Lhu;Lhu;)V"
   )
   AbstractWorldMapIcon(TileLocation var1, TileLocation var2) {
      this.coord1 = var1;
      this.coord2 = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1990181988"
   )
   public abstract int __m_15();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Laj;",
      garbageValue = "1159446036"
   )
   abstract WorldMapLabel __f_16();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "75"
   )
   abstract int __q_17();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1558233611"
   )
   abstract int __w_18();

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-63"
   )
   @Export("__y_66")
   boolean __y_66(int var1, int var2) {
      return this.__b_68(var1, var2)?true:this.__c_69(var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1150380891"
   )
   @Export("__h_67")
   boolean __h_67() {
      return this.__m_15() >= 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "484201257"
   )
   @Export("__b_68")
   boolean __b_68(int var1, int var2) {
      if(!this.__h_67()) {
         return false;
      } else {
         WorldMapElement var3 = ViewportMouse.getWorldMapElement(this.__m_15());
         int var4 = this.__q_17();
         int var5 = this.__w_18();
         switch(var3.field3287.field3528) {
         case 0:
            if(var1 < this.__e - var4 / 2 || var1 > var4 / 2 + this.__e) {
               return false;
            }
            break;
         case 1:
            if(var1 >= this.__e && var1 < var4 + this.__e) {
               break;
            }

            return false;
         case 2:
            if(var1 <= this.__e - var4 || var1 > this.__e) {
               return false;
            }
         }

         switch(var3.field3301.field3275) {
         case 0:
            if(var2 <= this.__x - var5 || var2 > this.__x) {
               return false;
            }
            break;
         case 1:
            if(var2 < this.__x - var5 / 2 || var2 > var5 / 2 + this.__x) {
               return false;
            }
            break;
         case 2:
            if(var2 < this.__x || var2 >= var5 + this.__x) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1201712205"
   )
   @Export("__c_69")
   boolean __c_69(int var1, int var2) {
      WorldMapLabel var3 = this.__f_16();
      return var3 == null?false:(var1 >= this.__e - var3.width / 2 && var1 <= var3.width / 2 + this.__e?var2 >= this.__x && var2 <= var3.height + this.__x:false);
   }

   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "(Lit;Ljava/lang/String;I)V",
      garbageValue = "-1018878027"
   )
   static void method625(IndexCache var0, String var1) {
      IndexCacheLoader var2 = new IndexCacheLoader(var0, var1);
      Client.indexCacheLoaders.add(var2);
      Client.__client_sx += var2.__q;
   }
}
