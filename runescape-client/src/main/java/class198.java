import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("gq")
public class class198 extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 916442491
   )
   public int field2870;
   @ObfuscatedName("c")
   static NodeCache field2871;
   @ObfuscatedName("d")
   public static IndexDataBase field2872;
   @ObfuscatedName("n")
   char field2874;
   @ObfuscatedName("p")
   boolean field2875;
   @ObfuscatedName("t")
   public String field2876;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "687267744"
   )
   void method3584() {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1877843552"
   )
   void method3585(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3593(var1, var2);
      }
   }

   class198() {
      this.field2875 = true;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1324719924"
   )
   public boolean method3586() {
      return this.field2874 == 115;
   }

   static {
      field2871 = new NodeCache(64);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "0"
   )
   void method3593(Buffer var1, int var2) {
      if(var2 == 1) {
         byte var4 = var1.readByte();
         int var5 = var4 & 255;
         if(var5 == 0) {
            throw new IllegalArgumentException("");
         }

         if(var5 >= 128 && var5 < 160) {
            char var6 = class210.field3134[var5 - 128];
            if(var6 == 0) {
               var6 = 63;
            }

            var5 = var6;
         }

         char var3 = (char)var5;
         this.field2874 = var3;
      } else if(var2 == 2) {
         this.field2870 = var1.readInt();
      } else if(var2 == 4) {
         this.field2875 = false;
      } else if(var2 == 5) {
         this.field2876 = var1.readString();
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-369115879"
   )
   static void method3598() {
      int var0 = class187.field2760;
      int var1 = IndexDataBase.field2726;
      if(GroundObject.field1285 < var0) {
         var0 = GroundObject.field1285;
      }

      if(class20.field221 < var1) {
         var1 = class20.field221;
      }

      if(Actor.field656 != null) {
         try {
            Client var2 = Client.field279;
            int var3 = Client.isResized?2:1;
            Object[] var4 = new Object[]{Integer.valueOf(var3)};
            JSObject.getWindow(var2).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "758065147"
   )
   static int method3599(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2773((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }
}
