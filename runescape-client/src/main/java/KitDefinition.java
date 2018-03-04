import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static IndexDataBase field3510;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2072311613
   )
   public static int field3508;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("identKits")
   static NodeCache identKits;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1355847479
   )
   @Export("bodyPartId")
   public int bodyPartId;
   @ObfuscatedName("y")
   @Export("modelIds")
   int[] modelIds;
   @ObfuscatedName("k")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("s")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("p")
   @Export("retextureToFind")
   short[] retextureToFind;
   @ObfuscatedName("x")
   @Export("retextureToReplace")
   short[] retextureToReplace;
   @ObfuscatedName("m")
   @Export("models")
   int[] models;
   @ObfuscatedName("h")
   @Export("nonSelectable")
   public boolean nonSelectable;

   static {
      identKits = new NodeCache(64);
   }

   KitDefinition() {
      this.bodyPartId = -1;
      this.models = new int[]{-1, -1, -1, -1, -1};
      this.nonSelectable = false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1823122987"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "0"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.bodyPartId = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.modelIds = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.modelIds[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 3) {
            this.nonSelectable = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.recolorToFind = new short[var3];
            this.recolorToReplace = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.recolorToFind[var4] = (short)var1.readUnsignedShort();
               this.recolorToReplace[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.retextureToFind = new short[var3];
            this.retextureToReplace = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.retextureToFind[var4] = (short)var1.readUnsignedShort();
               this.retextureToReplace[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.models[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "6"
   )
   @Export("ready")
   public boolean ready() {
      if(this.modelIds == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            if(!field3510.tryLoadRecord(this.modelIds[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ldf;",
      garbageValue = "888777327"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.modelIds == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.modelIds.length];

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            var1[var2] = ModelData.method2660(field3510, this.modelIds[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.recolorToFind != null) {
            for(var3 = 0; var3 < this.recolorToFind.length; ++var3) {
               var4.recolor(this.recolorToFind[var3], this.recolorToReplace[var3]);
            }
         }

         if(this.retextureToFind != null) {
            for(var3 = 0; var3 < this.retextureToFind.length; ++var3) {
               var4.method2674(this.retextureToFind[var3], this.retextureToReplace[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-25"
   )
   public boolean method4979() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.models[var2] != -1 && !field3510.tryLoadRecord(this.models[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Ldf;",
      garbageValue = "-1408395706"
   )
   public ModelData method4972() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.models[var3] != -1) {
            var1[var2++] = ModelData.method2660(field3510, this.models[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.recolorToFind != null) {
         for(var4 = 0; var4 < this.recolorToFind.length; ++var4) {
            var5.recolor(this.recolorToFind[var4], this.recolorToReplace[var4]);
         }
      }

      if(this.retextureToFind != null) {
         for(var4 = 0; var4 < this.retextureToFind.length; ++var4) {
            var5.method2674(this.retextureToFind[var4], this.retextureToReplace[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-651144691"
   )
   public static int method4974(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2136749875"
   )
   static void method4991() {
      class90.username = class90.username.trim();
      if(class90.username.length() == 0) {
         KeyFocusListener.method770("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class28.method237();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = ItemLayer.method2657(var1, class90.username);
         }

         switch(var0) {
         case 2:
            KeyFocusListener.method770("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class90.loginIndex = 6;
            break;
         case 3:
            KeyFocusListener.method770("", "Error connecting to server.", "");
            break;
         case 4:
            KeyFocusListener.method770("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            KeyFocusListener.method770("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            KeyFocusListener.method770("", "Error connecting to server.", "");
            break;
         case 7:
            KeyFocusListener.method770("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
