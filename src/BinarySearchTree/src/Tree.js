class Node{
    constructor(key) {
        this.key = key;
        this.right = null;
        this.left = null;
    }
    setRight(right){
        this.right = right;
    }

    setLeft(left){
        this.left = left;
    }
    setKey(key){
        this.key = key;
    }
    getLeft(){
        return this.left;
    }
    getRigth(){
        return this.right;
    }
    getKey(){
        return this.key;
    }
}